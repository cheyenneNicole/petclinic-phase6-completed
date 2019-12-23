package com.example.service;

import com.example.model.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="zuul-gateway-server")
@RibbonClient(name="customer-service")
public interface CustomerServiceProxy {

    @GetMapping("owner-service/customerapi/customer/getById/{id}")
    Customer getCustomerById(@PathVariable("id") long id);
}
