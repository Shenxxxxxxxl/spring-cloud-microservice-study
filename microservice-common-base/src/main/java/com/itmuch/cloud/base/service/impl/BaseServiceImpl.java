package com.itmuch.cloud.base.service.impl;

import com.itmuch.cloud.base.repository.BaseRepository;
import com.itmuch.cloud.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseRepository baseRepository;


}
