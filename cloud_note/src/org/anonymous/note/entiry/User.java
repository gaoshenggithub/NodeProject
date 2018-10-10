package org.anonymous.note.entiry;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	//序列化
	private static final long serialVersionUID = 1L;
	
	private String cn_user_id;
	private String cn_user_name;
	private String cn_user_password;
	private String cn_user_token;
	private String cn_user_nick;
	private List<NoteBook> books;
	/**
	 * @return the books
	 */
	public List<NoteBook> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<NoteBook> books) {
		this.books = books;
	}	/**
	 * @return the cn_user_id
	 */
	public String getCn_user_id() {
		return cn_user_id;
	}
	/**
	 * @param cn_user_id the cn_user_id to set
	 */
	public void setCn_user_id(String cn_user_id) {
		this.cn_user_id = cn_user_id;
	}
	/**
	 * @return the cn_user_name
	 */
	public String getCn_user_name() {
		return cn_user_name;
	}
	/**
	 * @param cn_user_name the cn_user_name to set
	 */
	public void setCn_user_name(String cn_user_name) {
		this.cn_user_name = cn_user_name;
	}
	/**
	 * @return the cn_user_password
	 */
	public String getCn_user_password() {
		return cn_user_password;
	}
	/**
	 * @param cn_user_password the cn_user_password to set
	 */
	public void setCn_user_password(String cn_user_password) {
		this.cn_user_password = cn_user_password;
	}
	/**
	 * @return the cn_user_token
	 */
	public String getCn_user_token() {
		return cn_user_token;
	}
	/**
	 * @param cn_user_token the cn_user_token to set
	 */
	public void setCn_user_token(String cn_user_token) {
		this.cn_user_token = cn_user_token;
	}
	/**
	 * @return the cn_user_nick
	 */
	public String getCn_user_nick() {
		return cn_user_nick;
	}
	/**
	 * @param cn_user_nick the cn_user_nick to set
	 */
	public void setCn_user_nick(String cn_user_nick) {
		this.cn_user_nick = cn_user_nick;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
