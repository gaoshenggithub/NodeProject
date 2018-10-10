package org.anonymous.note.dao.test.imple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClass {

	@Before
	public void before(){
		System.out.println("已经初始化!");
	}
	
	@After
	public void after(){
		System.out.println("已经销毁!");
	}
	@Test
	public void some(){
		System.out.println("已经执行!");
	}
	@Test
	public void any(){
		System.out.println("已经执行!*2");
		
	}
}
