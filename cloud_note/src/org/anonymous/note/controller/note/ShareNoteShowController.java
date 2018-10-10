package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class ShareNoteShowController {
	@Resource
	private ShareService shareService;
	
	@RequestMapping("/shareshow.do")
	@ResponseBody
	public NoteResult executeShow(String shareId){
		NoteResult result
			= shareService.shareShow(shareId);
		return result;
	}
}
