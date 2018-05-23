package com.itmuch.cloud.feign.client;

import com.itmuch.cloud.base.entity.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping("/{id}")
    public UserEntity findByIdFeign(@RequestParam("id") Long id);
}