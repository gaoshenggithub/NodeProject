package org.anonymous.note.dao.test.imple;

import javax.annotation.Resource;

import org.anonymous.note.dao.UserDao;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	
	@Resource
	private UserDao userDao;
	
	private UserService userService ;
	@Before
	public void init(){
		ApplicationContext context = 
				new  ClassPathXmlApplicationContext(
						"applicationContext.xml");
		userService = context.getBean(
				"userServiceImple",UserService.class);
	}
	@Test
	public void test1() throws Exception{
		NoteResult result = 
				userService.checkLogin("root", "123456789");
		//验证返回的结果是否正确,也就是业务逻辑是否正确
		Assert.assertEquals(0, result.getStatus());
	}
}
