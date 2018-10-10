package org.anonymous.note.dao.test.imple;

import java.util.List;

import org.anonymous.note.dao.AssicotionDao;
import org.anonymous.note.dao.test.TestBase;
import org.anonymous.note.entiry.NoteBook;
import org.anonymous.note.entiry.User;
import org.springframework.context.ApplicationContext;

public class TestAssicotionDao {
	public static void main(String[] args) {
		ApplicationContext context = TestBase.getApplicationContext();
		/*AssicotionDao as = context.getBean("assicotionDao",AssicotionDao.class);
		User user = as.findByUserId("48595f52-b22c-4485-9244-f4004255b972");
		List<NoteBook> list = user.getBooks();
		for (NoteBook noteBook : list) {
			String cn_notebook_name = noteBook.getCn_notebook_name();
			System.out.println(cn_notebook_name);
		}*/
		
	/*	AssicotionDao assDao = context.getBean("assicotionDao",AssicotionDao.class);
		List<User> list = assDao.findAll();
		for (User user : list) {
			System.out.println("用户--->"+user.getCn_user_name());
			List<NoteBook> books = user.getBooks();
			for (NoteBook noteBook : books) {
				System.out.println("用户笔记--->"+noteBook.getCn_notebook_name());
			}
			System.out.println();
		}*/
		 
		AssicotionDao assDao = context.getBean("assicotionDao",AssicotionDao.class);
		List<NoteBook> list = assDao.findBookNotes();
		for (NoteBook noteBook : list) {
			System.out.println(noteBook.getCn_notebook_id()+"__"+
								noteBook.getCn_notebook_name()+"__"+
					noteBook.getUser().getCn_user_name());
		}
	}
}
