package org.anonymous.note.controller.user;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class LoginController {
	//@Resource
	@Autowired
	private UserService userService;
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult executeLogin(String username,String password) throws Exception{
		NoteResult result = 
					userService.checkLogin(username, password);
		//String str = null;
		//str.length();
		return null;
	}
}
