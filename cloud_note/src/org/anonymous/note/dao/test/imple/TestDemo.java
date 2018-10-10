package org.anonymous.note.dao.test.imple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TestDemo {
	
	/**
	 * 每个测试方法开始测试的时候都会初始化
	 */
	@Before
	public void init(){
		System.out.println("初始化....");
	}
	
	
	/**
	 * 每一个测试方法结束的时候.销毁都会调用此方法
	 */
	@After
	public void destory(){
		System.out.println("销毁");
	}
	
	//带@Test都是测试方法
	@Test
	public void test1(){
		System.out.println("测试1");
	}
	
	@Test
	public void test2(){
		System.out.println("测试2");
	}
	/**
	 * 结果:
	 * 初始化....
		测试2
		销毁
		初始化....
		测试1
		销毁

	 */
	
}
