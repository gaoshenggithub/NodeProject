package org.anonymous.note.junit.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigApplicationContext {
	
	private static AbstractApplicationContext context = null;
	//初始化...
	public static AbstractApplicationContext getApplicationContext(){
		 context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return context;
	}
	
	//销毁
	public static void closeApplicationContext(){
		context.close();
	}
}
