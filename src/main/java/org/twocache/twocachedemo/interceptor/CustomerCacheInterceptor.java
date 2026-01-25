//package org.twocache.twocachedemo.interceptor;
//
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.AnnotationCacheOperationSource;
//import org.springframework.cache.annotation.Caching;
//import org.springframework.cache.caffeine.CaffeineCache;
//import org.springframework.cache.interceptor.CacheInterceptor;
//import org.springframework.cache.interceptor.CacheOperationSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCache;
//import org.springframework.stereotype.Component;
//import org.twocache.twocachedemo.cache.CustomizedRedisCacheManager;
//
//@Component
//public class CustomerCacheInterceptor extends CacheInterceptor {
//
//    private final CustomizedRedisCacheManager redisCacheManager;
//
//    //    public CustomerCacheInterceptor(CacheManager caffeineCacheManager) {
////        this.caffeineCacheManager = caffeineCacheManager;
////        this.setCacheOperationSources(new AnnotationCacheOperationSource());
////    }
//    public CustomerCacheInterceptor(CustomizedRedisCacheManager customizedRedisCacheManager) {
//        this.redisCacheManager = customizedRedisCacheManager;
//        this.setCacheOperationSources(new AnnotationCacheOperationSource());
//    }
//
//
//    /**
//     * 重写缓存获取方法，实现两级缓存机制
//     *
//     * 当从Redis缓存中获取到数据时，同时将数据放入Caffeine本地缓存中，
//     * 实现Redis+本地缓存的两级缓存策略，提高缓存访问速度
//
//     */
////    @Override
////    protected Cache.ValueWrapper doGet(Cache cache, Object key) {
////        // 从上级缓存获取数据
////        Cache.ValueWrapper existingCacheValue = super.doGet(cache, key);
////        System.out.println("interceptor......");
////        // 如果缓存值存在且当前缓存是Redis缓存，则同步到本地Caffeine缓存
////        if (existingCacheValue != null && cache.getClass() == RedisCache.class) {
////            System.out.println("redis Cache hit for key: " + key);
////            // 获取对应的Caffeine缓存实例
////            Cache caffeineCache = caffeineCacheManager.getCache(cache.getName());
////            if (caffeineCache != null) {
////                // 将Redis缓存中的值放入本地缓存
////                System.out.println("copy redis Cache  to caffeineCache : " + key);
////                caffeineCache.putIfAbsent(key, existingCacheValue.get());
////            }
////        } else if (cache.getClass() == CaffeineCache.class) {
////            System.out.println("caffeine Cache hit for key: " + key);
////        }
////        return existingCacheValue;
////    }
//
//    @Bean
//    public CacheInterceptor cacheInterceptor(CustomizedRedisCacheManager customizedRedisCacheManager) {
//        CustomerCacheInterceptor customerCacheInterceptor = new CustomerCacheInterceptor(customizedRedisCacheManager);
//        return customerCacheInterceptor;
//    }
//
////    @Bean
////    public CacheOperationSource cacheOperationSource() {
////        return new AnnotationCacheOperationSource();
////    }
//
//}
