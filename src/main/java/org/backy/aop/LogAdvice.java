package org.backy.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect
public class LogAdvice {
	
//	@Before("execution(* org.backy.service.SampleService*.*(..))")
//	@After("execution(* org.backy.service.SampleService*.*(..))")
//	@AfterReturning("execution(* org.backy.service.SampleService*.*(..))")
//	@AfterThrowing("execution(* org.backy.service.SampleService*.*(..))")//에러 발생시 찍어줌
	public void logBefore() {
		System.out.println("------------@AfterThrowing-------------");
	}
	
	@Around("execution(* org.backy.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		log.info("target >>" + pjp.getTarget());
		log.info("param >>" + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("time > " + (end-start));
		return result;
	}
}
