package org.anonymous.note.service;

import org.anonymous.note.entiry.NoteResult;

public interface UserService {
	NoteResult checkLogin(String username,String password)throws Exception;
	NoteResult regist(String username,String password ,String nickName)throws Exception;
	NoteResult updatePw(String userId, String oldPwd,String newPwd)throws Exception;
}
