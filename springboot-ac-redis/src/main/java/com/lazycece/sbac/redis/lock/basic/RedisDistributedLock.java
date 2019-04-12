//package com.lazycece.sbac.redis.lock.basic;
//
//
//import java.util.concurrent.TimeUnit;
//
///**
// * 基于Redis的SETNX、GETSET操作实现的分布式锁
// * 获取锁时最好用基类中定义的 tryLock(long time, TimeUnit unit)带参方法, 以免网路问题而导致线程一直阻塞
// * 阻塞不可排序，不可重入
// * <p>
// * Created by rui.jiao on 2016/12/8.
// */
//public class RedisDistributedLock extends AbstractLock {
//    //使用redis服务时间作为全局时间，避免本地时间不一致的情况
//    RedisTimeClient redisTimeClient;
//    // 锁的名字
//    protected String lockKey;
//
//    // 锁的有效时长(毫秒) 即线程持有锁的时长
//    protected long lockExpires;
//
//    // 锁对应key在redis的过期时间
//    private int keyExpire;
//
//
//    public RedisDistributedLock(String lockKey, long lockExpires) {
//        this.lockKey = lockKey;
//        this.lockExpires = lockExpires;
//        this.redisTimeClient = new RedisTimeClient();
//        this.keyExpire = (int) (3 * (lockExpires / 1000));
//    }
//
//    /**
//     * 阻塞式获取锁的实现 不能直接调用
//     *
//     * @param useTimeout true 获取锁操作中会判断是否阻塞超时
//     * @param time       阻塞时长
//     * @param unit       时长单位
//     * @param interrupt  是否响应中断
//     * @return
//     * @throws InterruptedException
//     */
//    @Override
//    protected boolean lock(boolean useTimeout, long time, TimeUnit unit, boolean interrupt) throws InterruptedException {
//        if (interrupt) {
//            checkInterruption();
//        }
//
//        // 获取锁操作的超时控制 的时间可以从本地获取, 因为这个和持有锁超时没有关系, 只是"尝试获取锁"操作阻塞时长的控制
//        long start = localTimeMillis();
//        long timeout = unit != null ? unit.toMillis(time) : 0; // if !useTimeout, then it's useless
////      useTimeout ? isTimeout(start, timeout) : true
//        while (!useTimeout || isTimeout(start, timeout)) {
//            if (interrupt) {
//                checkInterruption();
//            }
//
//            long lockExpireTime = serverTimeMillis() + lockExpires + 1;//锁超时时间
//            String stringOfLockExpireTime = String.valueOf(lockExpireTime);
//
//            if (RedisHelper.setNxStrAndExpire(lockKey, stringOfLockExpireTime, keyExpire)) { // 获取到锁
//                // 成功获取到锁, 设置相关标识
//                locked = true;
//                setExclusiveOwnerThread(Thread.currentThread());
//                return true;
//            }
//
//            Object value = RedisHelper.getAndExpire(lockKey, keyExpire);
//            if (value != null && isTimeExpired(String.valueOf(value))) { // lock is expired
//                if (atomicGetLockByTimeExpired(stringOfLockExpireTime)) {
//                    return true;
//                }
//            } else {
//                // 锁未过期，返回开头进行下一次获取锁尝试
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 通过getSet原子方法获取到之前锁超时时间oldvalue：
//     * 若当前线程拿到的oldValue已经超时，说明当前已获取到锁。
//     * 若当前线程拿到的oldValue未超时，则不做操作重头尝试获取锁
//     * 不论哪种情况getSet只会将超时时间延后一点，从而避免超时直接delkey造成的死锁
//     */
//    private boolean atomicGetLockByTimeExpired(String stringOfLockExpireTime) {
//        // 此处可能多个线程(非单jvm)同时走到这里
//        Object oldValue = RedisHelper.getSetAndExpire(lockKey, stringOfLockExpireTime, keyExpire); // getset is atomic
//        // 但是走到这里时每个线程拿到的oldValue肯定不一样(因为getset是原子性的)
//        // 若拿到的oldValue依然是expired的，那么就说明拿到锁了
//        if (oldValue != null && isTimeExpired(String.valueOf(oldValue))) {
//            // 成功获取到锁, 设置相关标识
//            locked = true;
//            setExclusiveOwnerThread(Thread.currentThread());
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 非阻塞式锁，尝试获取锁,获取不到直接返回false，不重试
//     *
//     * @return
//     */
//    @Override
//    public boolean tryLock() {
//        long lockExpireTime = serverTimeMillis() + lockExpires + 1;//锁超时时间
//        String stringOfLockExpireTime = String.valueOf(lockExpireTime);
//
//        if (RedisHelper.setNxStrAndExpire(lockKey, stringOfLockExpireTime, keyExpire)) { // 获取到锁
//            // 成功获取到锁, 设置相关标识
//            locked = true;
//            setExclusiveOwnerThread(Thread.currentThread());
//            return true;
//        }
//
//        Object value = RedisHelper.getAndExpire(lockKey, keyExpire);
//        if (value != null && isTimeExpired(String.valueOf(value))) { // lock is expired
//            return atomicGetLockByTimeExpired(stringOfLockExpireTime);
//        } else {
//            // 锁未过期，返回开头进行下一次获取锁尝试
//        }
//        return false;
//    }
//
//    /**
//     * 判断锁是否被其他线程持有
//     *
//     * @return
//     */
//    public boolean isLocked() {
//        if (locked) {
//            return true;
//        } else {
//            Object value = RedisHelper.getAndExpire(lockKey, keyExpire);
//            // 当get方法返回value后, 假设这个value已经是过期的了,
//            // 而就在这瞬间, 另一个节点set了value, 这时锁是被别的线程(节点持有), 而接下来的判断
//            // 是检测不出这种情况的.不过这个问题应该不会导致其它的问题出现, 因为这个方法的目的本来就
//            // 不是同步控制, 它只是一种锁状态的报告.
//            return !isTimeExpired(String.valueOf(value));
//        }
//    }
//
//    /**
//     * 释放锁的具体操作，删除redis中的key
//     */
//    @Override
//    protected void unlock0() {
//        String value = (String) RedisHelper.get(lockKey);
//        if (!isTimeExpired(value)) {
//            doUnlock();
//        }
//    }
//
//    /**
//     * 释放分布式锁功能持有的资源，由于爱唱的redisService由spring持有,timeClient这里不做释放
//     */
//    @Override
//    public void release() {
////                timeClient.close();
//    }
//
//    private void doUnlock() {
//        RedisHelper.delete(lockKey);
//    }
//
//    private void checkInterruption() throws InterruptedException {
//        if (Thread.currentThread().isInterrupted()) {
//            throw new InterruptedException();
//        }
//    }
//
//    private boolean isTimeExpired(String value) {
//        if (StringUtils.isBlank(value)) {
//            return true;
//        }
//        Long val = Long.parseLong(value);
//        // 这里拿服务器的时间来比较
//        return val == null || val < serverTimeMillis();
//    }
//
//    private boolean isTimeout(long start, long timeout) {
//        // 这里拿本地的时间来比较
//        return start + timeout > System.currentTimeMillis();
//    }
//
//    private long serverTimeMillis() {
//        return redisTimeClient.currentTimeMillis();
//    }
//
//    private long localTimeMillis() {
//        return System.currentTimeMillis();
//    }
//
//
//}
