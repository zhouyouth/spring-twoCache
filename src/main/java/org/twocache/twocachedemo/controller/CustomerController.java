package org.twocache.twocachedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twocache.twocachedemo.bean.Customer;
import org.twocache.twocachedemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private  CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable(value = "id",required = false)  Long customerId ) throws InterruptedException {
        return customerService.getCustomer(customerId);
    }

}
