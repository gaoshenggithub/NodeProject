package org.anonymous.note.service.imple;

import java.io.IOException;

import javax.annotation.Resource;

import org.anonymous.note.dao.UserDao;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.entiry.User;
import org.anonymous.note.service.UserService;
import org.anonymous.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImple implements UserService{
	
	@Resource
	private UserDao userDao;
	/**
	 * 登录模块业务处理
	 */
	@Override
	public NoteResult checkLogin(
			String username, String password) throws Exception {
		NoteResult result = new NoteResult();	
		System.out.println(username);
		System.out.println(password);
		User user = userDao.findByName(username);
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//对用户的密码进行加密
		String md5_base64_password = NoteUtil.md5_base64(password);
		if(!user.getCn_user_password().equals(md5_base64_password)){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确!");
		result.setData(user.getCn_user_id());
		String str = null;
		str.length();
		return result;
	}
	
	/**
	 * 注册业务逻辑处理
	 */
	@Override
	public NoteResult regist(String username, String password, String nickName) throws Exception {
		System.out.println("111");
		NoteResult result = new NoteResult();
		User user = new User();
		//校验用户名是否被占用
		User name = userDao.findByName(username);
		if(name!=null){
			result.setStatus(1);
			result.setMsg("用户名已被占用");
			return result;
		}
		//创建ID
		String cn_user_id = NoteUtil.create_UserId();
		user.setCn_user_id(cn_user_id);
		user.setCn_user_name(username);//用户名
		//对密码进行加密
		String md5_base64_password 
			= NoteUtil.md5_base64(password);
		//已经加密的密码
		user.setCn_user_password(md5_base64_password);
		user.setCn_user_nick(nickName);//昵称
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		String str = null;
		str.length();
		return result;
	}

	@Override
	public NoteResult updatePw(String userId, String oldPwd,String newPwd) throws Exception {
		String md5_base64_old_Pwd = NoteUtil.md5_base64(oldPwd); 
		String md5_base64_new_Pwd = NoteUtil.md5_base64(newPwd);
		System.out.println(md5_base64_old_Pwd);
		System.out.println(md5_base64_new_Pwd);
		NoteResult result = new NoteResult();
		User user = new User();
		User select_user = userDao.selectPwd(userId);
		
		String cn_user_password = select_user.getCn_user_password();
		System.out.println(cn_user_password);
		if(cn_user_password.equals(md5_base64_old_Pwd)){
			user.setCn_user_id(userId);
			user.setCn_user_password( md5_base64_new_Pwd );
			userDao.updatePassword(user);
			result.setStatus(0);
			result.setMsg("修改成功!");
			result.setData("");
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("原始密码不正确!");
			result.setData("");
			return result;
		}
		
	}


}
