package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class SearchNoteController {
	@Resource
	private ShareService shareService;
	
	@RequestMapping("/searchnote.do")
	@ResponseBody
	public NoteResult executeSearch(String keyNote){
		NoteResult result = 
					shareService.shareLikeTitle(keyNote);
		return result; 
		
	}
	
}
