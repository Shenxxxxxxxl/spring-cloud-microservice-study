package com.itmuch.cloud.rhystrix.service;

import com.itmuch.cloud.base.entity.UserEntity;

public interface RibbonHystrixService {
    public UserEntity findById(Long id);
}
