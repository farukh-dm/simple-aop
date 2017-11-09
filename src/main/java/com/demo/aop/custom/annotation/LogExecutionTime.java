package com.demo.aop.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime  {

	// 1. The @Target annotation tells us where our annotation will be applicable. 
	//    Here we are using ElementType.Method, which means it will only work on 
	//    methods. If we tried to use the annotation anywhere else, 
	//    then our code would fail to compile. 
	//    This behavior makes sense, as our annotation will be used for logging method execution time.

	// 2. @Retention just states whether the annotation will be available to the JVM 
	//    at runtime or not. By default it is not, so Spring AOP would not be able 
	//    to see the annotation. This is why it’s been reconfigured.
	
}
