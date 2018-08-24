package com.glarimy.spring.directory.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.glarimy.spring.directory.api.exceptions.InvalidEmployeeException;
import com.glarimy.spring.directory.api.model.Employee;

@Aspect
@Component
@Order(1)
public class EmployeeValidator {
	Logger logger = LoggerFactory.getLogger(EmployeeValidator.class);

	@Around("execution(* com.glarimy.spring.directory.service.*.add(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		Employee employee = (Employee) joinPoint.getArgs()[0];
		if (employee == null) {
			logger.error("invalid employee: employee is null");
			throw new InvalidEmployeeException();
		}
		if (employee.getName() == null) {
			logger.error("invalid employee: name is null");
			throw new InvalidEmployeeException();
		}
		if (employee.getName().trim().length() == 0) {
			logger.error("invalid employee: name is empty");
			throw new InvalidEmployeeException();
		}
		if (employee.getSalary() < 0) {
			logger.error("invalid employee: salary is negative");
			throw new InvalidEmployeeException();
		}
		Object o = joinPoint.proceed();
		return o;
	}

}
