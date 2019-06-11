package com.hand.service;


import com.hand.feign.EurekaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    private EurekaFeignClient eurekaFeignClient;

    public String sayHi(String name){
        return eurekaFeignClient.sayHiFromEurekaClient(name);
    }

}
