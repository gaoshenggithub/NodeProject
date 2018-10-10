package org.anonymous.note.dao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	public static ApplicationContext getApplicationContext(){
		String conf = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
		return applicationContext;
	}
	public static void main(String[] args) {
		String str = null;
		System.out.println(str);
		
	}
	@Test
	public void some(){
		System.out.println("!!!");
	}
	@Test
	public void any(){
		System.out.println("???");
	}
}
