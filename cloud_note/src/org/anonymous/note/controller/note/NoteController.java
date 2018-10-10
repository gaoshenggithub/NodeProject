package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class NoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult executeNoteLoads(String noteId){
		NoteResult result = noteService.loadNotes(noteId);
		return result;
	}
}
