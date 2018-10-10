package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class MoveNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/move.do")
	@ResponseBody
	public NoteResult execute(String noteId ,String noteBookId){
		NoteResult result = 
					noteService.move(noteId, noteBookId);
		return result;
	}
}
