package org.anonymous.note.dao.test.imple;

import java.lang.reflect.Method;

import org.anonymous.note.entiry.User;
import org.junit.Test;

public class TestIOC {
	private static final Object User = null;

	@Test
	public void ioc() throws Exception{
		String className = "org.anonymous.note.entiry.User";
		Class<?> clazz = Class.forName(className);
		//获取实例
		Object instance = clazz.newInstance();
		System.out.println(instance);
		//获取方法
		Method method = clazz.getMethod("setCn_user_name", String.class);
		System.out.println(method);
		method.invoke(instance, "demo");
		User user = (User)instance;
		String cn_user_name = user.getCn_user_name();
		System.out.println(cn_user_name);
	}
}
