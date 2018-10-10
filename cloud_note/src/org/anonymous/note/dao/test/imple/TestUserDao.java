package org.anonymous.note.dao.test.imple;

import org.anonymous.note.dao.UserDao;
import org.anonymous.note.dao.test.TestBase;
import org.anonymous.note.entiry.User;


public class TestUserDao extends TestBase{
	public static void main(String[] args) {
		UserDao userDao = 
				getApplicationContext().
					getBean("userDao",UserDao.class);
		User user = userDao.findByName("demo1");
		if(user==null){
			System.out.println("用户名不正确!");
		}else{
			System.out.println(user.getCn_user_password());
		}
	}
}
