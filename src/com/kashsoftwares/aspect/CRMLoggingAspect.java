package com.kashsoftwares.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger mLogger = Logger.getLogger(getClass().getName());
			
	// setup pointcut declaration for controller package
	@Pointcut("execution(* com.kashsoftwares.controller.*.*(..))")
	private void forControllerPackage() {}
	
	
	// setup pointcut declaration for service package
	@Pointcut("execution(* com.kashsoftwares.service.*.*(..))")
	private void forServicePackage() {}
		
	// setup pointcut declaration for dao package
	@Pointcut("execution(* com.kashsoftwares.dao.*.*(..))")
	private void forDaoPackage() {}
		
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		mLogger.info("===>in @Before: calling method: "+theMethod);
		
		// display arguments to the methods
		Object[] args = theJoinPoint.getArgs();
		for(Object arg: args) {
			mLogger.info("--->>>> argument: "+arg);
		}
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		
		// display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		mLogger.info(">>>>>>>>in @Before: calling method: <<<<<<< "+theMethod);
	
		// display arguments to the methods
		mLogger.info(">>>>>>>>>>> argument: <<<<<<< "+result);
		
	}

}
