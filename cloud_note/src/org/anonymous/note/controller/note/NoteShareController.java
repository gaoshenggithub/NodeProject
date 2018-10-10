package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class NoteShareController {
	
	@Resource
	private ShareService shareService;
	
	@RequestMapping("/sharenote.do")
	@ResponseBody
	public NoteResult executeNoteShare(String noteId){
		NoteResult result 
			= shareService.share(noteId);
		return result;
	}
}
