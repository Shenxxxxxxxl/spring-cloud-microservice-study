package com.itmuch.cloud.user.service;

import com.itmuch.cloud.base.entity.UserEntity;

public interface UserService {
    UserEntity findOne(Long id);
}
