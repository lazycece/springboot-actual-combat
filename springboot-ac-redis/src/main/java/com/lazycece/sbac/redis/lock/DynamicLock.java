//package com.lazycece.sbac.redis.lock;
//
//
//public class DynamicLock extends RedisDistributedLock {
//
//    public static final long LOCK_EXPIRES = 60000;
//
//    // cachekey 上线补偿活动分布式锁
//    private static final String DYNAMIC_LOCK = NameSpace.NAMESPACE + "lock:dynamicLock:%s";
//
//    public DynamicLock(String fieldKey) {
//        super(String.format(DYNAMIC_LOCK, fieldKey), LOCK_EXPIRES);
//    }
//}
