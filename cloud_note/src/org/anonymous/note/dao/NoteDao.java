package org.anonymous.note.dao;

import java.util.List;
import java.util.Map;

import org.anonymous.note.entiry.ActivityNote;
import org.anonymous.note.entiry.Note;

public interface NoteDao {
	public int deleteNotes(String[] string);
	public List<Map> findByBookId(String noteBookId);
	public void save(Note note);
	public Note findNoteId(String noteId);
	public void update(Note note);
	public void updateStatus(String noteId);
	public List<Note> findRecycleId(String userId);
	public void replayNote(Note note);
	public List<Note> hightSearch(Map map);
	public List<ActivityNote> selectActionNote();
	public void moveNote(Note note);
	public void deleteNote(String userId);
}
