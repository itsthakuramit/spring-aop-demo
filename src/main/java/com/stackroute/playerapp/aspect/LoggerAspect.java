package com.stackroute.playerapp.aspect;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Aspect
@Component
public class LoggerAspect {
	
	Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Before("execution(* com.stackroute.playerapp.controller.PlayerController.*(..))")
	public void logforHomepage(JoinPoint joinPoint) {
		logger.info("Inside Before Advice"+joinPoint.getSignature().getName());
	}
	
	
	@After("execution(* com.stackroute.playerapp.controller.PlayerController.*(..))")
	public void logforHP(JoinPoint joinPoint) {
		logger.info("Inside after Advice "+joinPoint.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.stackroute.playerapp.controller.PlayerController.*(..))")
	public void HP(JoinPoint joinPoint) {
		logger.info("Inside Afterthrowing Advice "+joinPoint.getSignature().getName());
	}
	
	
	
}


