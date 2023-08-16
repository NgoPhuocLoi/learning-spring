package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckRoleAspect {
    @Before("execution(* com.example.services.*.*(..)) && args(role)")
    public void checkRole(JoinPoint joinPoint, String role) throws Throwable {
        if (!role.equals("Admin")) {
            System.err.println("Error from checkingAspect");

            throw new Exception("Error!");
        }
    }
}
