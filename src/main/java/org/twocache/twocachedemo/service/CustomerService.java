package org.twocache.twocachedemo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.twocache.twocachedemo.bean.Customer;

import static java.lang.Thread.sleep;

@Service
public class CustomerService {
    private static CustomerRepository customerRepository ;
//    @Cacheable(cacheNames = "customerCache", cacheManager = "caffeineCacheManager")
//    public Customer getCustomer(Long customerId) throws InterruptedException {
//        sleep(500);
////        return (Customer) customerRepository.findById(customerId).orElse(null);
//        return  new Customer(1L,"张三");
//    }
    @Caching(cacheable = {
                    @Cacheable(cacheNames = "customerCache", cacheManager = "caffeineCacheManager"),
                    @Cacheable(cacheNames = "customerCache", cacheManager = "redisCacheManager"),
            })
    public Customer getCustomer(Long customerId) throws InterruptedException {
        sleep(500);
        System.out.println("get from database");
        return  new Customer(customerId,"张三");
    }
}
