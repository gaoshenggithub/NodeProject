package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class FindNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/findnote.do")
	@ResponseBody
	public NoteResult executefindNote(String noteId){
		NoteResult result = noteService.findNote(noteId);
		return result;
	}
}
