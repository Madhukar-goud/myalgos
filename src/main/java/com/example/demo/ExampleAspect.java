package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by madhukar on 17/05/19.
 */
@Aspect
@Component
public class ExampleAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(" ==> ==> ==> ==> ==> ==> ==> ==> ==> ==>"+ joinPoint.getSignature() + " executed in ==============================================" + executionTime + "ms");
        return proceed;
    }

}
