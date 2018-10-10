package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/updateNote.do")
	@ResponseBody
	public NoteResult executeUpdate(String noteTitle,
									String noteId,
									String noteBody){
		NoteResult result = noteService.updateNotes(
				noteTitle, noteId, noteBody);
		return result;
	}
}
