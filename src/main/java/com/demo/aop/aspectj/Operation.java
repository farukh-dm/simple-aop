package com.demo.aop.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.aop.custom.annotation.LogExecutionTime;

@Component(value="operation")
public class Operation {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Operation.class);

	public void msg() {
		LOGGER.debug("msg method invoked");
	}

	public int m() {
		LOGGER.debug("m method invoked");
		return 2;
	}

	public int k() {
		LOGGER.debug("k method invoked");
		return 3;
	}
	
	public void e() {
		LOGGER.debug("e method invoked");
		if(true) {
			throw new ArithmeticException("Not valid!");
		}
	}
	
	public int a() {
		LOGGER.debug("a method invoked");
		return 1;
	}
	
	public int pub() {
		return a();
	}
	
	private int priv() {
		return a();
	}
	
	public int runPriv() {
		return priv();
	}
	
	@LogExecutionTime
	public void log() {
		LOGGER.debug("in log..");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
