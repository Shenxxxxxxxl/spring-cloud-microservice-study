package com.itmuch.cloud.ribbon.controller;

import com.itmuch.cloud.base.entity.UserEntity;
import com.itmuch.cloud.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/ribbon/{id}")
    public UserEntity findById(@PathVariable Long id) {
        return this.ribbonService.findById(id);
    }
}
