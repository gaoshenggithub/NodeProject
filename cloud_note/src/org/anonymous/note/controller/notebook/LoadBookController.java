package org.anonymous.note.controller.notebook;

import javax.annotation.Resource;


import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notebook")
public class LoadBookController {
	//@Autowired
	@Resource
	private NoteBookService noteBookService;
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult executeLoadBooks(String userId){
		NoteResult result = noteBookService.loadBooks(userId);
		return result;
	}
}
