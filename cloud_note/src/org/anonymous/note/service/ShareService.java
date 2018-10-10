package org.anonymous.note.service;

import org.anonymous.note.entiry.NoteResult;

public interface ShareService {
	public NoteResult share(String noteId);
	public NoteResult shareLikeTitle(String keyNote);
	public NoteResult shareShow(String shareId);
}
