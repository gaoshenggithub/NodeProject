package org.anonymous.note.entiry;

import java.io.Serializable;

public class Activity implements Serializable{ 
	private static final long serialVersionUID = 1L;
	private String cn_activity_id;
	private String cn_activity_title;
	private String cn_activity_body;
	private Long cn_activity_end_time;
	/**
	 * @return the cn_activity_id
	 */
	public String getCn_activity_id() {
		return cn_activity_id;
	}
	/**
	 * @param cn_activity_id the cn_activity_id to set
	 */
	public void setCn_activity_id(String cn_activity_id) {
		this.cn_activity_id = cn_activity_id;
	}
	/**
	 * @return the cn_activity_title
	 */
	public String getCn_activity_title() {
		return cn_activity_title;
	}
	/**
	 * @param cn_activity_title the cn_activity_title to set
	 */
	public void setCn_activity_title(String cn_activity_title) {
		this.cn_activity_title = cn_activity_title;
	}
	/**
	 * @return the cn_activity_body
	 */
	public String getCn_activity_body() {
		return cn_activity_body;
	}
	/**
	 * @param cn_activity_body the cn_activity_body to set
	 */
	public void setCn_activity_body(String cn_activity_body) {
		this.cn_activity_body = cn_activity_body;
	}
	/**
	 * @return the cn_activity_end_time
	 */
	public Long getCn_activity_end_time() {
		return cn_activity_end_time;
	}
	/**
	 * @param cn_activity_end_time the cn_activity_end_time to set
	 */
	public void setCn_activity_end_time(Long cn_activity_end_time) {
		this.cn_activity_end_time = cn_activity_end_time;
	}
	
}
