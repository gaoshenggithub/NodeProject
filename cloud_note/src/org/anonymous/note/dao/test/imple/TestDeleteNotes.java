package org.anonymous.note.dao.test.imple;

import org.anonymous.note.dao.NoteDao;
import org.anonymous.note.dao.test.TestBase;
import org.springframework.context.ApplicationContext;

public class TestDeleteNotes {
	public static void main(String[] args) {
		ApplicationContext context = TestBase.getApplicationContext();
		NoteDao noteDao = 
					context.getBean("noteDao",NoteDao.class);
		String[] arr = {"fsaf-as-df-asdf-as-df-dsa","ss19055-30e8-4cdc-bfac-97c6bad9518f"};
		int deleteNotes = noteDao.deleteNotes(arr);
		System.out.println("删除的条数:"+deleteNotes);
	}
}
