package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("note")
public class RecycleIdController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/recycleNote.do")
	@ResponseBody
	public NoteResult executeRecycle(String userId){
		NoteResult result = noteService.findRecycleNote(userId);
		return result;
	}
}
