package com.itmuch.cloud.feign.controller;

import com.itmuch.cloud.base.entity.UserEntity;
import com.itmuch.cloud.feign.client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/{id}")
    public UserEntity findByIdFeign(@PathVariable Long id) {
        UserEntity user = this.userFeignClient.findByIdFeign(id);
        return user;
    }
}