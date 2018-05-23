package com.itmuch.cloud.rhystrix.controller;

import com.itmuch.cloud.base.entity.UserEntity;
import com.itmuch.cloud.rhystrix.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonHystrixController {
    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon/{id}")
    public UserEntity findById(@PathVariable Long id) {
        return this.ribbonHystrixService.findById(id);
    }
}