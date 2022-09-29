package com.yieldstreet.challenge.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.yieldstreet.challenge.service.*.*(..))")
	public void serviceCallLog(JoinPoint joinPoint) {
		logger.info(" Service method called: " + joinPoint.toString());
		logArgs(joinPoint);
	}
	
	@Before("execution(* com.yieldstreet.challenge.controller.*.*(..))")
	public void controllerCallLog(JoinPoint joinPoint) {
		logger.info(" REST service called: " + joinPoint.toString());
		logArgs(joinPoint);
	}
	
	private void logArgs(JoinPoint joinPoint) {
		logger.info("Input args: ");
		for(Object arg: joinPoint.getArgs())
			logger.info(arg.toString());
		
	}
}
