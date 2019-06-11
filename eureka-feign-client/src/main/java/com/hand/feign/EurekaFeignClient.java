package com.hand.feign;


import com.hand.config.FeignConfig;
import com.hand.hystrix.HiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaFeignClient {

    @GetMapping("/hi")
    String sayHiFromEurekaClient(@RequestParam(value = "name") String name);
}
