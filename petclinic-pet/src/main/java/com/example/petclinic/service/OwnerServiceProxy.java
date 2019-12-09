package com.example.petclinic.service;

import com.example.petclinic.model.Owner;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="zuul-gateway-server")
@RibbonClient(name="owner-service")
public interface OwnerServiceProxy {

    @GetMapping("owner-service/ownerapi/owner/getById/{id}")
    Owner getOwnerById(@PathVariable("id") long id);
}
