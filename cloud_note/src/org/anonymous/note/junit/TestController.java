package org.anonymous.note.junit;

import javax.annotation.Resource;

import org.anonymous.note.controller.user.LoginController;
import org.anonymous.note.entiry.NoteResult;
import org.junit.Assert;
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
@ContextConfiguration(
		locations={"classpath:applicationContext.xml"})
public class TestController {
	@Resource
	private LoginController loginController;
	
	//测试API
	private MockMvc mvc;
	
	@Before
	public void init(){//全局初始化
		mvc = MockMvcBuilders.standaloneSetup(
						loginController).build();
	}
	@Test
	public void test1() throws Exception{
		//发送请求
		MockHttpServletRequestBuilder request = 
				MockMvcRequestBuilders.post("/user/login.do");
		//添加请求参数
		request.param("username", "demo")
			   .param("password", "1234");
		//发送请求,获取请求结果
		MvcResult result = mvc.perform(request).andReturn();
		String str = result.getResponse().getContentAsString();
		//System.out.println(str);
		
		//为了断言.需要将str字符串转换为NoteResult对象
		ObjectMapper mapper = new ObjectMapper();
		NoteResult value = mapper.readValue(str, NoteResult.class);
		
		//开始断言.
		Assert.assertEquals(2, value.getStatus());
		System.out.println(value.getStatus());
		
	}
}
