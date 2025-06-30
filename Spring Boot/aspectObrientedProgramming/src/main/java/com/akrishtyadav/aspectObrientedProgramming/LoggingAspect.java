package com.akrishtyadav.aspectObrientedProgramming;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("@within(org.springframework.stereotype.Service)")
    public void beforeSMethod(){
        System.out.println("Called before the service method!!");
    }

    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void beforeCMethod(){
        System.out.println("Called before the controller method!!");
    }
}
