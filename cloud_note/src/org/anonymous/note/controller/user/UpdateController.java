package org.anonymous.note.controller.user;

import javax.annotation.Resource;

import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UpdateController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult execute(String userId,String oldPwd,String newPwd) throws Exception{
		NoteResult result = userService.updatePw(userId, oldPwd,newPwd);
		return result;
	}
	
}
