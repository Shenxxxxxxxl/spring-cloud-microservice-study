package com.itmuch.cloud.ribbon.service.ServiceImpl;

import com.itmuch.cloud.base.entity.UserEntity;
import com.itmuch.cloud.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServiceImpl implements RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserEntity findById(Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, UserEntity.class);
    }
}
