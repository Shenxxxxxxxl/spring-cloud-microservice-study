package com.itmuch.cloud.rhystrix.service.impl;

import com.itmuch.cloud.base.entity.UserEntity;
import com.itmuch.cloud.rhystrix.service.RibbonHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixServiceImpl implements RibbonHystrixService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     * @param id id
     * @return 通过id查询到的用户
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public UserEntity findById(Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, UserEntity.class);
    }

    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    public UserEntity fallback(Long id) {
        RibbonHystrixServiceImpl.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        UserEntity user = new UserEntity();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }
}
