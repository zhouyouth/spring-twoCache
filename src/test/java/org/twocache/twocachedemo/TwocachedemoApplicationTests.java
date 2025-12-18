package org.twocache.twocachedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.twocache.twocachedemo.bean.Customer;
import org.twocache.twocachedemo.config.CacheConfig;
import org.twocache.twocachedemo.service.CustomerService;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TwocachedemoApplicationTests {
    @Autowired
   private   CustomerService customerService;
    @Autowired
    private CacheConfig cacheConfig;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        Customer customer = customerService.getCustomer(1L);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime)+"ms");
        Long startTime1 = System.currentTimeMillis();
        Customer customer1 = customerService.getCustomer(1L);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime1)+"ms"); // 第二次调用，从缓存中获取数据，耗时更短
        System.out.println(customer1.toString());
        Long startTime2 = System.currentTimeMillis();
        Customer customer2 = customerService.getCustomer(1L);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime2)+"ms"); // 第三次调用，从缓存中获取数据，耗时更短
        System.out.println(customer2.toString());
    }
    @Test
    public void test3() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        Customer customer = customerService.getCustomer(1L);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime)+"ms");
//        Long startTime1 = System.currentTimeMillis();
//        Customer customer1 = customerService.getCustomer(1L);
//        System.out.println("耗时：" + (System.currentTimeMillis() - startTime1)+"ms"); // 第二次调用，从缓存中获取数据，耗时更短
//        System.out.println(customer1.toString());
//        Long startTime2 = System.currentTimeMillis();
//        Customer customer2 = customerService.getCustomer(1L);
//        System.out.println("耗时：" + (System.currentTimeMillis() - startTime2)+"ms"); // 第三次调用，从缓存中获取数据，耗时更短
//        System.out.println(customer2.toString());
    }


    //todo 测试缓存 get CustomerManager 错误
    @Test
    void givenCustomerIsPresent_whenGetCustomerCalledTwiceAndFirstCacheExpired_thenReturnCustomerAndCacheIt() throws InterruptedException {
        Long CUSTOMER_ID = 6L;
        Customer customer = new Customer(CUSTOMER_ID, "test");


        Customer customerCacheMiss = customerService.getCustomer(CUSTOMER_ID);
        TimeUnit.SECONDS.sleep(3);
        Customer customerCacheHit = customerService.getCustomer(CUSTOMER_ID);
    }
}

