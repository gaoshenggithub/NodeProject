package org.anonymous.note.service;

import org.anonymous.note.entiry.NoteResult;

public interface NoteService {
	public NoteResult loadNotes(String noteBookId);
	public NoteResult addNotes(String noteTitle,
			String bookId,String userId);
	public NoteResult findNote(String noteId);
	public NoteResult updateNotes(String noteTitle,
			String noteId,String noteBody);
	public NoteResult recycleNote(String noteId);
	public NoteResult findRecycleNote(String userId);
	public NoteResult recycleNoteId(String noteId,String bookNoteId);
	public NoteResult search(String title,String status,String beginTime,String endTime);
	public NoteResult move(String noteId ,String noteBookId);
	public NoteResult delete(String userId);
}
