package org.anonymous.note.controller.user;

import javax.annotation.Resource;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/user")
public class RegistController {
	@Resource
	public UserService userService;
	@RequestMapping("/regist.do")
	@ResponseBody
	public NoteResult executeRegist(String username,
									String password,
									String nickName) throws Exception{
		NoteResult result = userService.regist(username, password, nickName);
		return result;
	}
}
