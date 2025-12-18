package org.twocache.twocachedemo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig {
    private static final int CAFFEINE_CACHE_EXPIRATION_TIME = 1;
    private static final int REDIS_CACHE_EXPIRATION_TIME = 6;
    @Bean
    public CaffeineCache caffeineCacheConfig() {
        return new CaffeineCache("customerCache", Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofMinutes(CAFFEINE_CACHE_EXPIRATION_TIME))
                .initialCapacity(1)
                .maximumSize(2000)
                .build());
    }
    @Bean
    @Primary
    public CacheManager caffeineCacheManager(CaffeineCache caffeineCache) {
        System.out.println("caffeineCacheManager...get");
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(caffeineCache));
        return manager;
    }
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(REDIS_CACHE_EXPIRATION_TIME))// 设置缓存过期时间为5分钟
//                .disableCachingNullValues(); // 禁止缓存空值
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json())); // 使用JSON序列化方式
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.java())); // 使用Java序列化方式
    }
    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory, RedisCacheConfiguration cacheConfiguration) {
        System.out.println("redisManager...get");
        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(connectionFactory)
                .withCacheConfiguration("customerCache", cacheConfiguration)
                .build();
    }
}
