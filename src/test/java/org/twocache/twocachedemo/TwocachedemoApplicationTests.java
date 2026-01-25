package org.twocache.twocachedemo;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import org.twocache.twocachedemo.bean.Customer;
import org.twocache.twocachedemo.bean.Person;
import org.twocache.twocachedemo.config.AnnotationConfig;

import org.twocache.twocachedemo.service.CustomerService;
import org.twocache.twocachedemo.service.RedisService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TwocachedemoApplicationTests {


    private AnnotationConfigApplicationContext context;

    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
    }

    @Test
    public void  testRedis() throws Exception{
        RedisService redisService = (RedisService) context.getBean("redisService");
        while (true) {
            String result = redisService.getRedidInfo("redis_test", "default_value1");
            log.info(result);
            Thread.sleep(1000);
        }
    }

    @Test
    public void testPersons() throws Exception{
        RedisService redisService = (RedisService) context.getBean("redisService");
        while (true) {
            List<Person> list = redisService.getPersons();
            log.info("获取到的列表长度：" + list.size());
            Thread.sleep(1000);
        }
    }
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private LettuceConnectionFactory connectionFactory;
    @Test
    public void testCustomer() throws Exception{
        RedisTemplate<String, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setConnectionFactory(connectionFactory);
        objectObjectRedisTemplate.setKeySerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.setValueSerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.afterPropertiesSet();
        System.out.println("redisTemplate..........");
        objectObjectRedisTemplate.opsForValue().set("test111", "00990wewewe", 3600, TimeUnit.SECONDS);
        System.out.println(objectObjectRedisTemplate.opsForValue().get("gh3222"));
        System.out.println(objectObjectRedisTemplate.opsForValue().get("gh3222"));
        System.out.println(objectObjectRedisTemplate.opsForValue().get("gh3222"));
    }
}

