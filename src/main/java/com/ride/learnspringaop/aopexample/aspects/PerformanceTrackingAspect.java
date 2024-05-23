package com.ride.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("com.ride.learnspringaop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();

        Object returnValue = null;
        try {
            returnValue = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {

            long stopTimeMillis = System.currentTimeMillis();
            long executionDuration = stopTimeMillis - startTimeMillis;
            logger.error("Around Aspect - {} Method executed in {} ms - Exception: {}"
                    , proceedingJoinPoint
                    , executionDuration
                    , throwable.getMessage());
            throw throwable;
        }
        long stopTimeMillis = System.currentTimeMillis();
        long executionDuration = stopTimeMillis - startTimeMillis;
        logger.info("Around Aspect - {} Method executed in {} ms"
                , proceedingJoinPoint
                , executionDuration);
        return returnValue;
    }
}