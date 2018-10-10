package org.anonymous.note.dao.test.imple;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.anonymous.note.controller.user.LoginController;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)//加运行类加入容器中
@ContextConfiguration(
		locations={"classpath:applicationContext.xml"})//指定配置文件
public class TestController {
	@Resource
	private LoginController loginController;
	
	private MockMvc mockmvc;
	
	@Before
	public void init(){
		mockmvc = MockMvcBuilders.standaloneSetup(
				loginController).build();
	}
	
	@Test
	public void test1() throws Exception{
		//发送请求
		MockHttpServletRequestBuilder requestBuilder = 
					MockMvcRequestBuilders.post("/user/login.do");
		//发送请求参数
		requestBuilder.param("username", "demo").param("password","1234" );
		//发送请求.获取请求返回的结果
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		String content = result.getResponse()
					.getContentAsString();
		System.out.println(content);
		/**
		 * 到这里就是获取到响应的结果了
		 * {"status":0,
		 * "msg":"用户名和密码正确!",
		 * "data":"48595f52-b22c-4485-9244-f4004255b972"}
		 * 怎么是一个JSON数据?
		 * 这里就要将JSON数据转换为User对象
		 */
		
		//为了断言.将JSON数据转换为NoteResult对象
		ObjectMapper mapper = new ObjectMapper();
		//将JSON转换为NoteResult
		NoteResult note = 
				mapper.readValue(content, NoteResult.class);
		Assert.assertEquals(2, note.getStatus());
	}
}
