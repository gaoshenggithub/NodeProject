package org.anonymous.note.dao;

import java.util.List;
import java.util.Map;

import org.anonymous.note.entiry.NoteBook;

public interface NoteBookDao {
	public List<Map> findByUser(String userId);
	public void save(NoteBook noteBook);
}
