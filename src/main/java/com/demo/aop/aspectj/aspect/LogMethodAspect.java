package com.demo.aop.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component(value="logOperationAspect")
public class LogMethodAspect {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(LogMethodAspect.class);
	
	@Around("@annotation(com.demo.aop.custom.annotation.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	    
		long start = System.currentTimeMillis();
		 
	    Object proceed = joinPoint.proceed();
	 
	    long executionTime = System.currentTimeMillis() - start;
	 
	    LOGGER.debug("logExecutionTime: " + joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    
	    return proceed;
		
	}
	
}
