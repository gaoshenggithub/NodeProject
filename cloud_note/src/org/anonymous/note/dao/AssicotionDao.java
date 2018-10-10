package org.anonymous.note.dao;

import java.util.List;


import org.anonymous.note.entiry.NoteBook;
import org.anonymous.note.entiry.User;

public interface AssicotionDao {
	public User findByUserId(String userId);
	//public List<NoteBook> findNoteBook(String userId);
	public List<User> findAll();
	public List<NoteBook> findBookNotes();
}
