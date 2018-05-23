package com.itmuch.cloud.ribbon.service;

import com.itmuch.cloud.base.entity.UserEntity;

public interface RibbonService {
    public UserEntity findById(Long id);
}
