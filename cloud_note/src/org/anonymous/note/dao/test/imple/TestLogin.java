package org.anonymous.note.dao.test.imple;


import javax.annotation.Resource;

import org.anonymous.note.dao.UserDao;
import org.anonymous.note.dao.test.TestBase;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.entiry.User;
import org.anonymous.note.service.UserService;
import org.anonymous.note.service.imple.UserServiceImple;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class TestLogin {
	@Resource
	 private UserService service;
	@Before
	public void init(){
		 ApplicationContext app = TestBase.getApplicationContext();
		 service = app.getBean("userServiceImple",UserService.class);
	}
	@Test
	public void test1() throws Exception{
		NoteResult result = service.checkLogin("demo", "1234");
		Assert.assertEquals(2,result.getStatus());	
	}
	@Test
	public void test2() throws Exception{
		NoteResult result = service.checkLogin("root", "123456789");
		Assert.assertEquals(0,result.getStatus());	
	}
	@Test
	public void test3() throws Exception{
		NoteResult result = service.checkLogin("demo", "34");
		Assert.assertEquals(2,result.getStatus());	
	}
}
