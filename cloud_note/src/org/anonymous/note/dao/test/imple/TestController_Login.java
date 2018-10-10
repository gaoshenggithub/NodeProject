package org.anonymous.note.dao.test.imple;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.anonymous.note.controller.user.LoginController;
import org.anonymous.note.entiry.NoteResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestController_Login {
	@Resource
	private LoginController loginController;
	
	private MockMvc mvc ;
	@Before
	public void init(){
		mvc = MockMvcBuilders.standaloneSetup(
				loginController).build();
	}
	
	@Test
	public void test_Controller_Login() throws Exception{
		//创建请求
		MockHttpServletRequestBuilder post_Request = MockMvcRequestBuilders.post("/user/login.do");
		//添加参数
		post_Request.param("username", "root")
		.param("password", "123456789");
		MvcResult result = mvc.perform(post_Request).andReturn();
		String string = result.getResponse().getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		NoteResult value = objectMapper.readValue(string, NoteResult.class);
		Assert.assertEquals(0, value.getStatus());
		
		
	}
}
