package org.anonymous.note.dao.test.imple;

import java.util.Date;
import java.util.List;

import org.anonymous.note.entiry.Note;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSearch {
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ApplicationContext app =
					new ClassPathXmlApplicationContext(conf);
		NoteService noteService = app.getBean("noteServiceImple",NoteService.class);
		NoteResult result = noteService.search("1", "1", "2018-4-15", "2018-4-15");
		List<Note> list = (List)result.getData();
		for (Note note : list) {
			System.out.println(note.getCn_note_title()+"<---->"+new Date(note.getCn_note_create_time()).toLocaleString());
		}
		System.out.println("信息的记录条数:"+list.size());
	}
	
}
