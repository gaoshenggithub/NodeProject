package org.anonymous.note.dao;

import java.util.List;
import java.util.Map;

import org.anonymous.note.entiry.Share;

public interface ShareDao {
	public Share findId(String shareId);
	public Share findShareNoteId(String noteId);
	public void save(Share share);
	public List<Map> findLikeTitle(String keyNote);
}
