package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger
{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    @Around("@annotation(MethodStats)")
    public Object log(ProceedingJoinPoint point) throws Throwable
    {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        System.out.println("==> ==> ==> ==> ==> ==> ==> ==> Time from ASPECT ==> " + (System.currentTimeMillis() - start));
        return result;
    }
}