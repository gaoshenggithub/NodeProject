package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.ActionNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class ActionNoteController {
	@Resource
	private ActionNoteService actionNoteService;
	
	@RequestMapping("/actionnote.do")
	@ResponseBody
	public NoteResult execute(){
		NoteResult result =
				actionNoteService.actionNote();
		return result;
	}
}
