package org.anonymous.note.service;

import org.anonymous.note.entiry.NoteResult;

public interface NoteBookService {
	public NoteResult loadBooks(String userId);
	public NoteResult addBooks(String bookName,String userId);
}
