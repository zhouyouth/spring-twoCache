//package org.twocache.twocachedemo.config;
//
//import com.github.benmanes.caffeine.cache.Caffeine;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.caffeine.CaffeineCache;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCache;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.twocache.twocachedemo.cache.CacheTime;
//import org.twocache.twocachedemo.cache.CustomizedRedisCacheManager;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
////@Configuration
////@EnableCaching
//public class CacheConfig {
//   // private static final int CAFFEINE_CACHE_EXPIRATION_TIME = 1;
//    private static final int REDIS_CACHE_EXPIRATION_TIME = 6;
////    @Bean
////    public CaffeineCache caffeineCacheConfig() {
////        return new CaffeineCache("customerCache", Caffeine.newBuilder()
////                .expireAfterWrite(Duration.ofMinutes(CAFFEINE_CACHE_EXPIRATION_TIME))
////                .initialCapacity(1)
////                .maximumSize(2000)
////                .build());
////    }
////    @Bean
////    @Primary
////    public CacheManager caffeineCacheManager(CaffeineCache caffeineCache) {
////        System.out.println("caffeineCacheManager...get");
////        SimpleCacheManager manager = new SimpleCacheManager();
////        manager.setCaches(Arrays.asList(caffeineCache));
////        return manager;
////    }
////    @Bean
////    public RedisCacheConfiguration cacheConfiguration() {
////        return RedisCacheConfiguration.defaultCacheConfig()
////                .entryTtl(Duration.ofMinutes(REDIS_CACHE_EXPIRATION_TIME))// 设置缓存过期时间为5分钟
//////                .disableCachingNullValues(); // 禁止缓存空值
////                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json())); // 使用JSON序列化方式
//////                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.java())); // 使用Java序列化方式
////    }
////    @Bean
////    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory, RedisCacheConfiguration cacheConfiguration) {
////        // 使用 LockingRedisCacheWriter 启用锁机制
////        RedisCacheWriter lockingCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
////        System.out.println("redisManager...get");
////        return RedisCacheManager.RedisCacheManagerBuilder
////                .fromConnectionFactory(connectionFactory)
////                .cacheWriter(lockingCacheWriter)
////                .withCacheConfiguration("customerCache", cacheConfiguration)
////                .build();
////    }
////    @Bean
////    public KeyGenerator keyGenerator() {
////        return new SimpleKeyGenerator();
////    }
////    @Bean
////    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
////        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
////                .entryTtl(Duration.ofSeconds(600))
////                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
////                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
////
////        return RedisCacheManager.builder(RedisCacheWriter.lockingRedisCacheWriter(connectionFactory))
////                .cacheDefaults(config)
////                .build();
////    }
//
//}
