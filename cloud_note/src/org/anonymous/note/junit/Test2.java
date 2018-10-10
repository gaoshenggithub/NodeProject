package org.anonymous.note.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test2 {
	@Before
	public void v2(){
		System.out.println("初始化....");
	}
	
	@After
	public void v3(){
		System.out.println("销毁");
	}
	
	@Test
	public void v1(){
		System.out.println("运行中...");
		System.out.println(1==2);
	}
	
	@Test
	public void v4(){
		System.out.println("....");
	}
}
