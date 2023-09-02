package com.example.easy_school_app.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Around("execution(* com.example.easy_school_app..*.*(..))")
    public Object logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature() + " is started!");
        Instant start = Instant.now();
        Object result = joinPoint.proceed();
        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();

        log.info("Time took to execute " + joinPoint.getSignature().toString() + " method is : " + duration);
        log.info(joinPoint.getSignature().toString() + " method execution end");
        return result;
    }

    @AfterThrowing(value = "execution(* com.eazybytes.eazyschool.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error(joinPoint.getSignature() + " An exception happened due to : " + ex.getMessage());
    }
}
