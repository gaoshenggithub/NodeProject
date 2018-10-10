package org.anonymous.note.controller.notebook;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notebook")
public class AddBookController {
	@Resource
	private NoteBookService noteBookService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String bookName,String userId){
		NoteResult result = noteBookService.addBooks(bookName, userId);
		System.out.println(bookName);
		return result;
	}
}
