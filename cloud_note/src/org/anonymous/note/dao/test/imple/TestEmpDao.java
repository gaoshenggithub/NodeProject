package org.anonymous.note.dao.test.imple;

import org.anonymous.note.dao.EmpDao;
import org.anonymous.note.dao.test.TestBase;
import org.anonymous.note.entiry.Emp;
import org.springframework.context.ApplicationContext;

public class TestEmpDao {
	public static void main(String[] args) {
		ApplicationContext context = TestBase.getApplicationContext();
		EmpDao empDao = context.getBean("empDao",EmpDao.class);
		Emp emp = new Emp();
		emp.setName("Spring");
		emp.setAge(1);
		empDao.save(emp);
		System.out.println(emp.getId());
		
	}
}
