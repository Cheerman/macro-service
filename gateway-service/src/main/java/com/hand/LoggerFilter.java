package com.hand;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;


@Component
public class LoggerFilter extends ZuulFilter{

    public static String PRE_TYPE = "pre";


    @Autowired
    Tracer tracer;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        tracer.addTag("operator", "ben");
        System.out.println("traceId: " + tracer.getCurrentSpan().getTraceId());
        return null;
    }
}
