package com.hand.hystrix;

import com.hand.feign.EurekaFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author: ben.niu01@hand-china.com
 * @version: 1.0
 * @date: 2019/5/23
 */
@Component
public class HiHystrix implements EurekaFeignClient {

    @Override
    public String sayHiFromEurekaClient(String name) {
        return "hi " + name + " sorry, error!";
    }
}
