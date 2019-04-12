//package com.lazycece.sbac.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.connection.RedisServerCommands;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author CC
// * 2017.12.20
// */
//@SuppressWarnings(value = {"unchecked"})
//public class RedisHelper {
//    public final static Logger LOGGER = LoggerFactory.getLogger(RedisHelper.class);
//    public static final RedisTemplate redisTemplate = SpringApplicationContext.getRedisTemplate();
//
//    public static Set<String> keys(String pattern) {
//        try {
//            return redisTemplate.keys(pattern);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void expire(String key, long timeout, TimeUnit unit) {
//        try {
//            if (!hasKey(key)) {
//                return;
//            }
//            redisTemplate.expire(key, timeout, unit);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void set(String key, Object o, long timeout, TimeUnit unit) {
//        if (o == null || (o instanceof Collection && ((Collection) o).isEmpty())) {
//            return;
//        }
//        try {
//            redisTemplate.opsForValue().set(key, JsonUtil.obj2Str(o), timeout, unit);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void setJson(String key, Object o) {
//        if (o == null || (o instanceof Collection && ((Collection) o).isEmpty())) {
//            return;
//        }
//        try {
//            redisTemplate.opsForValue().set(key, JsonUtil.obj2Str(o));
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void setNoJson(String key, Object o, long timeout, TimeUnit unit) {
//        if (o == null || (o instanceof Collection && ((Collection) o).isEmpty())) {
//            return;
//        }
//        try {
//            redisTemplate.opsForValue().set(key, o, timeout, unit);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static <T> T get(String key, Class<T> clazz) {
//        try {
//            if (!hasKey(key)) {
//                return null;
//            }
//            String json = (String) redisTemplate.opsForValue().get(key);
//            return JsonUtil.str2Obj(json, clazz);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Object get(String key, Class<? extends Collection> collectionType, Class clazz) {
//        try {
//            if (!hasKey(key)) {
//                return null;
//            }
//            String json = (String) redisTemplate.opsForValue().get(key);
//            return JsonUtil.str2Collection(json, collectionType, clazz);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Object get(String key) {
//        try {
//            if (!hasKey(key)) {
//                return null;
//            }
//            return redisTemplate.opsForValue().get(key);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Boolean setIfAbsent(String key, Object o) {
//        try {
//            if (o != null) {
//                return redisTemplate.opsForValue().setIfAbsent(key, JsonUtil.obj2Str(o));
//            }
//            return false;
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Boolean hasKey(String key) {
//        try {
//            return redisTemplate.hasKey(key);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Boolean delete(String key) {
//        try {
//            if (!hasKey(key)) {
//                return true;
//            }
//            return redisTemplate.delete(key);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void multiDelete(String pattern) {
//        try {
//            Set keys = redisTemplate.keys(pattern);
//            if (keys != null) {
//                redisTemplate.delete(keys);
//            }
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void setHashJson(String key, String hashKey, Object o) {
//        try {
//            if (o != null) {
//                redisTemplate.opsForHash().put(key, hashKey, JsonUtil.obj2Str(o));
//            }
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void setHash(String key, String hashKey, Object o) {
//        try {
//            if (o != null) {
//                redisTemplate.opsForHash().put(key, hashKey, o);
//            }
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void putAllHash(String key, Map map) {
//        try {
//            if (map != null && map.size() > 0) {
//                redisTemplate.opsForHash().putAll(key, map);
//            }
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static <T> T getHash(String key, String hashKey, Class<T> clazz) {
//        try {
//            if (!hasKey(key)) {
//                return null;
//            }
//            String json = (String) redisTemplate.opsForHash().get(key, hashKey);
//            return json == null ? null : JsonUtil.str2Obj(json, clazz);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static String getHash(String key, String hashKey) {
//        try {
//            if (!hasKey(key)) {
//                return null;
//            }
//            return (String) redisTemplate.opsForHash().get(key, hashKey);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    /**
//     * 获取hash表所有field的值
//     *
//     * @param key
//     * @return
//     */
//    public static List<Object> hGetVals(String key) {
//        if (key == null) {
//            return null;
//        }
//        try {
//            return redisTemplate.opsForHash().values(key);
//        } catch (Throwable e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    /**
//     * 获取hash表所有数据 field + value
//     *
//     * @param key
//     * @return
//     */
//    public static Map hGetAll(String key) {
//        if (key == null) {
//            return null;
//        }
//        try {
//            return redisTemplate.opsForHash().entries(key);
//        } catch (Throwable e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Object getHash(String key, String hashKey, Class<? extends Collection> collectionType, Class clazz) {
//        try {
//            if (!hasKey(key)) {
//                return null;
//            }
//            String json = (String) redisTemplate.opsForHash().get(key, hashKey);
//            return json == null ? null : JsonUtil.str2Collection(json, collectionType, clazz);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//
//    public static void delHash(String key, String hashKey) {
//        try {
//            redisTemplate.opsForHash().delete(key, hashKey);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void addListLeft(String key, Object o) {
//        try {
//            redisTemplate.opsForList().leftPush(key, JsonUtil.obj2Str(o));
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void addListLeft(String key, Collection values) {
//        try {
//            redisTemplate.opsForList().leftPushAll(key, values);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void addListRight(String key, Object o) {
//        try {
//            redisTemplate.opsForList().rightPush(key, JsonUtil.obj2Str(o));
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void addListRight(String key, Collection values) {
//        try {
//            redisTemplate.opsForList().rightPushAll(key, values);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Object listIndex(String key, long index) {
//        try {
//            return redisTemplate.opsForList().index(key, index);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static <T> T listIndex(String key, long index, Class<T> clazz) {
//        try {
//            String json = (String) redisTemplate.opsForList().index(key, index);
//            return JsonUtil.str2Obj(json, clazz);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static <T> T listPopRight(String key, Class<T> clazz) {
//        try {
//            String json = (String) redisTemplate.opsForList().rightPop(key);
//            return JsonUtil.str2Obj(json, clazz);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static <T> T listPopLeft(String key, Class<T> clazz) {
//        try {
//            String json = (String) redisTemplate.opsForList().leftPop(key);
//            return JsonUtil.str2Obj(json, clazz);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long listSize(String key) {
//        try {
//            return redisTemplate.opsForList().size(key);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static <T> List<T> listRange(String key, long start, long end, Class<T> clazz) {
//        try {
//            List<String> jsonList = redisTemplate.opsForList().range(key, start, end);
//            List<T> list = new ArrayList<>();
//            for (String str : jsonList) {
//                list.add(JsonUtil.str2Obj(str, clazz));
//            }
//            return list;
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void sSetAdd(String key, Collection collection) {
//        try {
//            if (collection == null || collection.isEmpty()) {
//                return;
//            }
//            redisTemplate.opsForSet().add(key, collection.toArray());
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long sSetSize(String key) {
//        try {
//            if (hasKey(key)) {
//                return redisTemplate.opsForSet().size(key);
//            }
//            return (long) 0;
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static List sSetRandomMembers(String key, int count) {
//        try {
//            return redisTemplate.opsForSet().randomMembers(key, count);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void zSetAddJson(String key, Object o, double score) {
//        try {
//            redisTemplate.opsForZSet().add(key, JsonUtil.obj2Str(o), score);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void zSetAdd(String key, Object o, double score) {
//        try {
//            redisTemplate.opsForZSet().add(key, o, score);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long zSetSize(String key) {
//        try {
//            return redisTemplate.opsForZSet().zCard(key);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void zSetRemoveRange(String key, int start, int stop) {
//        try {
//            redisTemplate.opsForZSet().removeRange(key, start, stop);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static void zSetRemoveRangeByScore(String key, double min, double max) {
//        try {
//            redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Object zSetRangeByScore(String key, double min, double max) {
//        try {
//            return redisTemplate.opsForZSet().rangeByScore(key, min, max);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Object zSetRangeByScoreWithScore(String key, double min, double max) {
//        try {
//            return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Set<Object> zSetRange(String key, int start, int stop) {
//        try {
//            return redisTemplate.opsForZSet().range(key, start, stop);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Set<Object> zSetReverseRange(String key, int start, int stop) {
//        try {
//            return redisTemplate.opsForZSet().reverseRange(key, start, stop);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long zSetRank(String key, Object member) {
//        try {
//            return redisTemplate.opsForZSet().rank(key, JsonUtil.obj2Str(member));
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long zSetReverseRank(String key, Object member) {
//        try {
//            return redisTemplate.opsForZSet().reverseRank(key, JsonUtil.obj2Str(member));
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Object zSetRangeWithScore(String key, int start, int stop) {
//        try {
//            return redisTemplate.opsForZSet().rangeWithScores(key, start, stop);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long zSetCount(String key, double min, double max) {
//        try {
//            return redisTemplate.opsForZSet().count(key, min, max);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Double zSetIncrby(String key, Object o, double score) {
//        try {
//            return redisTemplate.opsForZSet().incrementScore(key, JsonUtil.obj2Str(o), score);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long zRemoveJson(String key, Object o) {
//        try {
//            return redisTemplate.opsForZSet().remove(key, JsonUtil.obj2Str(o));
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    public static Long zRemove(String key, Object o) {
//        try {
//            return redisTemplate.opsForZSet().remove(key, o);
//        } catch (Exception e) {
//            throw new RedisException(e.getMessage());
//        }
//    }
//
//    /**
//     * 获取redis系统时间 单位：TimeMillis
//     */
//    public static long redisTime() {
//        return (long) redisTemplate.execute(RedisServerCommands::time);
//    }
//
//    /**
//     * String操作:setnx and expire
//     * expireSeconds 单位秒
//     */
//    public static boolean setNxStrAndExpire(String key, String value, long expireSeconds) {
//        if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
//            return false;
//        }
//        boolean result = redisTemplate.opsForValue().setIfAbsent(key, value);
//        if (result && expireSeconds > 0) {
//            redisTemplate.expire(key, expireSeconds, TimeUnit.SECONDS);
//        }
//        return result;
//    }
//
//    /**
//     * 刷新key的超时时间
//     * get命令，获取key的value，获取成功设置过期时间。
//     * expireSeconds 单位秒
//     */
//    public static Object getAndExpire(String key, int expireSeconds) {
//        if (StringUtils.isBlank(key)) {
//            return null;
//        }
//        Object result = redisTemplate.opsForValue().get(key);
//        if (result != null && expireSeconds > 0) {
//            redisTemplate.expire(key, expireSeconds, TimeUnit.SECONDS);
//        }
//        return result;
//    }
//
//    /**
//     * getset命令,获取key的value并修改，返回修改之前的值oldvalue。如果key不存在则返回null；获取成功设置过期时间。
//     */
//    public static Object getSetAndExpire(String key, String value, int expireSeconds) {
//        if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
//            return null;
//        }
//        Object result = redisTemplate.opsForValue().getAndSet(key, value);
//        if (result != null && expireSeconds > 0) {
//            redisTemplate.expire(key, expireSeconds, TimeUnit.SECONDS);
//        }
//        return result;
//    }
//}
