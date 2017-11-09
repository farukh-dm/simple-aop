package com.demo.aop.aspectj.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component(value="trackOperationAspect")
public class TrackOperationAspect {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(TrackOperationAspect.class);
	
	// --------------------------------------------------------------------------
	
	@Pointcut("execution(* com.demo.aop.aspectj.Operation.m(..))")
	public void trackM() { } //common pointcut name that can be re-used.
	 
	@Before("trackM()") //Before poincut
	public void getBeforeAdviceForM(JoinPoint jp) {
		LOGGER.debug("Executing Before Advice for trackM().." + jp.toString());
		LOGGER.debug("Agruments Passed=" + Arrays.toString(jp.getArgs()));
	}
	
	@After("trackM()") //Before poincut
	public void getAfterAdviceForM(JoinPoint jp) {
		LOGGER.debug("Executing After Advice for trackM().." + jp.toString());
	}
	
	// ------------------------------------------------------------------
	
	@Before("execution(* com.demo.aop.aspectj.Operation.k(..))")
	public void getBeforeAdviceForK(JoinPoint jp){
		LOGGER.debug("Executing Before Advice for k()" + jp.toString());
		LOGGER.debug("Agruments Passed=" + Arrays.toString(jp.getArgs()));
	}
	
	@After("execution(* com.demo.aop.aspectj.Operation.k(..))")
	public void getAfterAdviceForK(JoinPoint jp){
		LOGGER.debug("Executing After Advice for k()" + jp.toString());
	}
	
	@AfterReturning(
		pointcut="execution(* com.demo.aop.aspectj.Operation.k(..))", 
		returning="returnString")
	public void getAfterReturningAdviceForK(JoinPoint jp,Object returnString){
		LOGGER.debug("Executing After Returning Advice for k() " + returnString.toString());
	}
	
	// ----------------------------------------------------------------
	@AfterThrowing(
		pointcut="execution(* com.demo.aop.aspectj.Operation.e(..))", 
		throwing="error")
	public void getAfterThrowingAdviceForE(JoinPoint jp, Throwable error) {
		LOGGER.debug("Executing After throwing Advice for e() " + jp.toString());
		LOGGER.debug("Method Signature: "  + jp.getSignature());  
		LOGGER.debug("Exception is: " + error);  
    }
	
	@After("execution(* com.demo.aop.aspectj.Operation.e(..))")
	public void getAfterAdviceForE(JoinPoint jp) {
		LOGGER.debug("Executing After Advice for e() " + jp.toString());
    }
	
	// --------------------------------------------------------------
	
	@Around("execution(* com.demo.aop.aspectj.Operation.a(..))")
	public Object getAroundAdviceForA(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		LOGGER.debug("Executing around Advice for a() ");
		Object value = null;
		try {
			LOGGER.debug("executing... ");
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			LOGGER.error("Exception: " + e);
		}
		LOGGER.debug("After invoking getAroundAdviceForA() method. Return value=" + value);
		return value;
		
    }
	
}
