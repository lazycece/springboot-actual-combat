//package com.lazycece.sbac.redis.lock.basic;
//
//
//
///**
// * 使用redis提供的时间服务
// * Created by rui.jiao on 2016/12/9.
// */
//public class RedisTimeClient implements TimeClient {
//
//    /**
//     * 返回redis服务器时间，如果获取不到，使用本地时间
//     */
//    @Override
//    public long currentTimeMillis() {
//        long time = RedisHelper.redisTime();
//        return time == 0 ? System.currentTimeMillis() : time;
//    }
//}
