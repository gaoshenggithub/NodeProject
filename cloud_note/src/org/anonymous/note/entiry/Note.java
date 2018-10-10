package org.anonymous.note.entiry;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cn_note_id;
	private String cn_notebook_id;
	private String cn_user_id;
	private String cn_note_status_id;
	private String cn_note_type_id;
	private String cn_note_title;
	private String cn_note_body;
	private Long cn_note_create_time;
	private Long cn_note_last_modify_time;
	/**
	 * @return the createTime
	 */
	public String getCreateTime(){
			if(cn_note_create_time!=null){
			Date date = new Date(cn_note_create_time);
			//格式化
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = format.format(date);
			return strDate;
		}
			return "";
	}
	/**
	 * @return the cn_note_id
	 */
	public String getCn_note_id() {
		return cn_note_id;
	}
	/**
	 * @param cn_note_id the cn_note_id to set
	 */
	public void setCn_note_id(String cn_note_id) {
		this.cn_note_id = cn_note_id;
	}
	/**
	 * @return the cn_notebook_id
	 */
	public String getCn_notebook_id() {
		return cn_notebook_id;
	}
	/**
	 * @param cn_notebook_id the cn_notebook_id to set
	 */
	public void setCn_notebook_id(String cn_notebook_id) {
		this.cn_notebook_id = cn_notebook_id;
	}
	/**
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
	 * @return the cn_note_status_id
	 */
	public String getCn_note_status_id() {
		return cn_note_status_id;
	}
	/**
	 * @param cn_note_status_id the cn_note_status_id to set
	 */
	public void setCn_note_status_id(String cn_note_status_id) {
		this.cn_note_status_id = cn_note_status_id;
	}
	/**
	 * @return the cn_note_type_id
	 */
	public String getCn_note_type_id() {
		return cn_note_type_id;
	}
	/**
	 * @param cn_note_type_id the cn_note_type_id to set
	 */
	public void setCn_note_type_id(String cn_note_type_id) {
		this.cn_note_type_id = cn_note_type_id;
	}
	/**
	 * @return the cn_note_title
	 */
	public String getCn_note_title() {
		return cn_note_title;
	}
	/**
	 * @param cn_note_title the cn_note_title to set
	 */
	public void setCn_note_title(String cn_note_title) {
		this.cn_note_title = cn_note_title;
	}
	/**
	 * @return the cn_note_body
	 */
	public String getCn_note_body() {
		return cn_note_body;
	}
	/**
	 * @param cn_note_body the cn_note_body to set
	 */
	public void setCn_note_body(String cn_note_body) {
		this.cn_note_body = cn_note_body;
	}
	/**
	 * @return the cn_note_create_time
	 */
	public Long getCn_note_create_time() {
		return cn_note_create_time;
	}
	/**
	 * @param cn_note_create_time the cn_note_create_time to set
	 */
	public void setCn_note_create_time(Long cn_note_create_time) {
		this.cn_note_create_time = cn_note_create_time;
	}
	/**
	 * @return the cn_note_last_modify_time
	 */
	public Long getCn_note_last_modify_time() {
		return cn_note_last_modify_time;
	}
	/**
	 * @param cn_note_last_modify_time the cn_note_last_modify_time to set
	 */
	public void setCn_note_last_modify_time(Long cn_note_last_modify_time) {
		this.cn_note_last_modify_time = cn_note_last_modify_time;
	} 
}
