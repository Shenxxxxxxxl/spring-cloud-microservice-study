package com.itmuch.cloud.fhystrix.controller;

import com.itmuch.cloud.base.entity.UserEntity;
import com.itmuch.cloud.fhystrix.client.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHystrixController {
    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("feign/{id}")
    public UserEntity findByIdFeign(@PathVariable Long id) {
        UserEntity user = this.userFeignHystrixClient.findByIdFeign(id);
        return user;
    }
}