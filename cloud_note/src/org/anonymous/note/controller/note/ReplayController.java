package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class ReplayController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/replayNote.do")
	@ResponseBody
	public NoteResult executeReplay(
					String noteId ,String bookNoteId){
		NoteResult result = 
					noteService.recycleNoteId(noteId, bookNoteId);
		return result;
	}
}
