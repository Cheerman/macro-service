package com.hand.controller;

import com.hand.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return ribbonService.hi(name);
    }


    /**
     * 测试EurekaClient注册的服务列表中服务
     * @return
     */
    @GetMapping ("/testRibbon")
    public String testRibbon() {

        ServiceInstance instance = loadBalancer.choose("eureka-client");
        return instance.getHost() + ":" + instance.getPort();
    }

    /**
     * 测试手动配置服务列表中的服务
     * @return
     */
    @GetMapping ("/testSelfConfigRibbon")
    public String testSelfConfigRibbon() {
        ServiceInstance instance = loadBalancer.choose("stores");
        return instance.getHost() + ":" + instance.getPort();
    }
}
