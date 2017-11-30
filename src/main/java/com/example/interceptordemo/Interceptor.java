package com.example.interceptordemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Interceptor {

  @Around("execution(public * org.springframework.data.repository.Repository+.*(..))")
  public Object allRepositories(ProceedingJoinPoint joinPoint) throws Throwable {
    Object result = joinPoint.proceed();
    System.err.println(joinPoint.toShortString() + ": " + result);
    return result;
  }
}
