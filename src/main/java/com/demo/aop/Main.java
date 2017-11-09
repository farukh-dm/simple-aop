package com.demo.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.aop.aspectj.Operation;

public class Main {

	private static ApplicationContext context;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		LOGGER.debug("Hello World!");
		
		context = new ClassPathXmlApplicationContext("spring/application-context.xml");
		Operation bean = (Operation)context.getBean("operation");
		bean.k();
		bean.m();
		try {
			bean.e();
		} catch(Exception e) {
			//for later use.
		}
		
		int a = bean.a();
		
		// 1. Local or internal method calls within an advised class don’t get intercepted by proxy, 
		//    so the advice method of the aspect does not get fired or invoked.
		// 2. Once once you mark a class as an aspect, Spring excludes it from being auto-proxied.
		bean.pub();
		
		// 3. Methods with private, protected, or default visibility will not be advised.
		bean.runPriv();
		
		bean.log();
		
		LOGGER.debug("All Ok");

	}

}
