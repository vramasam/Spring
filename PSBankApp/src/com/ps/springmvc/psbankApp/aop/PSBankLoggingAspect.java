package com.ps.springmvc.psbankApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

/**
 * Class using Aspect for annotation and Component for the class to get scan
 * @author vivekramasamy
 *
 */
@Aspect
@Component
public class PSBankLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// First star defines the any class with in that package, 
	// second star defines any method with in that class and the .. defines any argument
	@Pointcut("execution(* com.ps.springmvc.psbankApp.controller.*.*(..))")
	private void forControllersPackage() {}
	
	@Pointcut("execution(* com.ps.springmvc.psbankApp.services.*.*(..))")
	private void forServicesPackage() {}
	
	@Pointcut("execution(* com.ps.springmvc.psbankApp.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllersPackage() || forServicesPackage() || forDAOPackage()")
	private void forApplication() {}
	
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Information: in @before Advice: Calling the method: " + methodName);
	}
	
	@AfterReturning(pointcut="forApplication()", returning="result") 
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("Info: In @AfterReturning: From method: " + methodName);
		logger.info("Info: Data Returned by Method:" + result);
	}
			
 
}
