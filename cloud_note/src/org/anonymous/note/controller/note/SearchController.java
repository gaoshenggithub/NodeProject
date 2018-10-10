package org.anonymous.note.controller.note;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class SearchController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult executeSearch(String title,
			String status,String beginTime,String endTime){
		NoteResult result = noteService.search(
				title, status, beginTime, endTime);
		return result;
	}
}
