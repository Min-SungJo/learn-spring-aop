package com.ride.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.ride.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {
    }

    @Pointcut("execution(* com.ride.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {
    }

    @Pointcut("execution(* com.ride.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {
    }

    @Pointcut("bean(*Service*)")
    public void allServicePackageConfigUsingBean() {
    }

    @Pointcut("@annotation(com.ride.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {
    }
}