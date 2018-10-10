package org.anonymous.note.dao;

import org.anonymous.note.entiry.User;

public interface UserDao {
	public User findByName(String name);
	public void save(User user);
	public void updatePassword(User user);
	public User selectPwd(String userId);
}
