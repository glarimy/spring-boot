package com.glarimy.spring.directory.aspects;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Auditor {
	@Around("execution(* com.glarimy.spring.directory.service.*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println(new Date() + " [Auditor] : " + joinPoint.getSignature().getName() + " - entering");
		Object o = joinPoint.proceed();
		System.out.println(new Date() + " [Auditor] : " + joinPoint.getSignature().getName() + " - leaving");
		return o;
	}

}
