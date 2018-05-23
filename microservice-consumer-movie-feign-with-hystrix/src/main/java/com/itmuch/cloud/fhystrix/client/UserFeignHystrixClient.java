package com.itmuch.cloud.fhystrix.client;

import com.itmuch.cloud.base.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-provider-user", fallback = UserFeignHystrixClient.HystrixClientFallback.class)
public interface UserFeignHystrixClient {
    @RequestMapping("/{id}")
    public UserEntity findByIdFeign(@RequestParam("id") Long id);

    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     * @author eacdy
     */
    @Component
    static class HystrixClientFallback implements UserFeignHystrixClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

        /**
         * hystrix fallback方法
         * @param id id
         * @return 默认的用户
         */
        @Override
        public UserEntity findByIdFeign(Long id) {
            HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            UserEntity user = new UserEntity();
            user.setId(-1L);
            user.setUsername("default username");
            user.setAge(0);
            return user;
        }
    }
}