package com.itmuch.cloud.user.service.impl;

import com.itmuch.cloud.base.entity.UserEntity;
import com.itmuch.cloud.user.repository.UserRepository;
import com.itmuch.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findOne(Long id) {
        return userRepository.findOne(id);
    }
}
