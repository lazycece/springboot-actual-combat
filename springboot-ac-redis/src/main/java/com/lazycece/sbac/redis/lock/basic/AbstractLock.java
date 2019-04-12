//package com.lazycece.sbac.redis.lock.basic;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * 锁的基类，实现基本方法, 具体获取锁的步骤由子类去实现.
// */
//public abstract class AbstractLock implements Lock {
//
//    /**
//     * 这里需不需要保证可见性值得讨论, 因为是分布式的锁,
//     * 1.同一个jvm的多个线程使用不同的锁对象其实也是可以的, 这种情况下不需要保证可见性
//     * 2.同一个jvm的多个线程使用同一个锁对象, 那可见性就必须要保证
//     * <p>
//     * 当前设置为volatile保证一个jvm使用同一个锁对象
//     */
//    protected volatile boolean locked;
//
//    /**
//     * 当前jvm内持有该锁的线程(if have one)
//     */
//    private Thread exclusiveOwnerThread;
//
//    /**
//     * 阻塞式锁，阻塞当前线程获取锁,没有设置获取锁操作的阻塞时间，因此会一直尝试获取锁，持锁线程阻塞不响应interrupt操作
//     * 如果一直竞争不到锁可能造成当前线程一直阻塞
//     */
//    @Override
//    public void lock() {
//        try {
//            lock(false, 0, null, false);
//        } catch (InterruptedException e) {
//            // TODO ignore
//        }
//    }
//
//    /**
//     * 阻塞式锁,没有设置获取锁操作的阻塞时间，因此会一直尝试获取锁，
//     * 持锁线程可以通过interrupt中断阻塞，放弃获取锁，并抛出InterruptedException
//     *
//     * @throws InterruptedException
//     */
//    @Override
//    public void lockInterruptibly() throws InterruptedException {
//        lock(false, 0, null, true);
//    }
//
//    /**
//     * 阻塞式锁，设置了获取锁线程的最大阻塞时间，会在阻塞时间内一直获取锁,超过最大时间终止阻塞，返回false
//     *
//     * @param time
//     * @param unit
//     * @return
//     */
//    @Override
//    public boolean tryLock(long time, TimeUnit unit) {
//        try {
//            return lock(true, time, unit, false);
//        } catch (InterruptedException e) {
//            // TODO ignore
//        }
//        return false;
//    }
//
//    /**
//     * 阻塞式锁，设置了获取锁线程的最大阻塞时间，会在阻塞时间内一直获取锁,超过最大时间终止阻塞，返回false
//     * 持锁线程可以通过interrupt中断阻塞，放弃获取锁，并抛出InterruptedException
//     *
//     * @param time
//     * @param unit
//     * @return
//     */
//    @Override
//    public boolean tryLockInterruptibly(long time, TimeUnit unit) throws InterruptedException {
//        return lock(true, time, unit, true);
//    }
//
//    /**
//     * 释放锁操作，先检查当前线程是否是持锁线程，不是直接抛出IllegalMonitorStateException
//     * 持锁线程则进行对应具体释放锁操作
//     */
//    @Override
//    public void unlock() {
//        // TODO 检查当前线程是否持有锁
//        if (Thread.currentThread() != getExclusiveOwnerThread()) {
//            throw new IllegalMonitorStateException("current thread does not hold the lock");
//        }
//
//        unlock0();
//        setExclusiveOwnerThread(null);
//    }
//
//    protected void setExclusiveOwnerThread(Thread thread) {
//        exclusiveOwnerThread = thread;
//    }
//
//    protected final Thread getExclusiveOwnerThread() {
//        return exclusiveOwnerThread;
//    }
//
//    protected abstract void unlock0();
//
//    /**
//     * 阻塞式获取锁的实现
//     *
//     * @param useTimeout
//     * @param time
//     * @param unit
//     * @param interrupt  是否响应中断
//     * @return
//     * @throws InterruptedException
//     */
//    protected abstract boolean lock(boolean useTimeout, long time, TimeUnit unit, boolean interrupt) throws InterruptedException;
//
//}
