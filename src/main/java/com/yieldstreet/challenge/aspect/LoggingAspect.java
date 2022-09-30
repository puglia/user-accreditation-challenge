package com.yieldstreet.challenge.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.yieldstreet.challenge.service.*.*(..))")
	public void serviceCallLog(JoinPoint joinPoint) {
		String joinPointName = joinPoint.toString();
		logger.info(Marker.ANY_NON_NULL_MARKER," Service method called: {0}", joinPointName);
		logArgs(joinPoint);
	}
	
	@Before("execution(* com.yieldstreet.challenge.controller.*.*(..))")
	public void controllerCallLog(JoinPoint joinPoint) {
		String joinPointName = joinPoint.toString();
		logger.info(Marker.ANY_NON_NULL_MARKER," REST service called: {0}", joinPointName);
		logArgs(joinPoint);
	}
	
	private void logArgs(JoinPoint joinPoint) {
		logger.info("Input args: ");
		for(Object arg: joinPoint.getArgs()) {
			String argAsString = arg.toString();
			logger.info(argAsString);
			}
		
	}
}
