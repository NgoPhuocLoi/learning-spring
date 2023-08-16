package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.beans.User;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.example.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log from logAspect before " + joinPoint.getSignature().toString() + " is called");
        joinPoint.proceed();
        System.out.println("Log from logAspect after " + joinPoint.getSignature().toString() + " is called\n\n");
    }

    @AfterReturning(value = "execution(* com.example.services.*.*(..))", returning = "reVal")
    public void afterProceed(JoinPoint joinPoint, User reVal) {
        System.out.println("After returning:: " + reVal);
    }

    @Around("@annotation(com.example.annotations.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log from logWithAnnotation before " + joinPoint.getSignature().toString() + " is called");
        joinPoint.proceed();
        System.out
                .println("Log from logWithAnnotation after " + joinPoint.getSignature().toString() + " is called\n\n");
    }
}
