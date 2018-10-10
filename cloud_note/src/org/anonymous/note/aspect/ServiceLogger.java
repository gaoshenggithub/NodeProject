package org.anonymous.note.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("serviceLogger")
@Aspect
public class ServiceLogger {
	
	@Before(value = "within(org.anonymous.note.service..*)")
	public void slogger(){
		System.out.println("进入Service");
	}
}
