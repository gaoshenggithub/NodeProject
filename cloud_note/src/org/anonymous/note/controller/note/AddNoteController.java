package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	
	@Resource
	private NoteService noteService;
	@RequestMapping("/addnote.do")
	@ResponseBody
	public NoteResult executeAddnote(String noteTitle,
			String bookId,String userId){
		NoteResult result = noteService.addNotes(
							noteTitle, bookId, userId);
		return result;
	}
}
