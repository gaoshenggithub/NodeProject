package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("action")
public class ActivityController {
	@Resource
	private ActivityService activityService;
	
	@RequestMapping("/action.do")
	@ResponseBody
	public NoteResult execute(){
		NoteResult result = activityService.actionNote();
		return result;
	}
}
