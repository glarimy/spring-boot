package com.glarimy.spring.bank.aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Validator {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Around("execution(* com.glarimy.spring.bank.service.*.*(..))")
	public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		for (Object o : args) {
			@SuppressWarnings("rawtypes")
			Class claz = o.getClass();
			if (claz.getAnnotation(Validatable.class) != null) {
				Method[] methods = claz.getMethods();
				for (Method method : methods) {
					if (method.getName().startsWith("get")) {
						if (method.getAnnotation(NotNull.class) != null) {
							Object value = method.invoke(o);
							if (value == null)
								throw new ValidationException("Value is null");
						}
					}
					if (method.getAnnotation(Positive.class) != null) {
						Object value = method.invoke(o);
						Class type = method.getReturnType();
						if (type == int.class || type == long.class) {
							long longValue = (long) value;
							if (longValue < 0)
								throw new ValidationException("Value is negative");
						} else if (type == float.class || type == double.class) {
							double doubleValue = (double) value;
							if (doubleValue < 0)
								throw new ValidationException("Value is negative");
						}
					}

				}
			}
		}
		Object o = joinPoint.proceed();
		return o;
	}
}