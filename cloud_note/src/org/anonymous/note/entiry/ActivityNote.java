package org.anonymous.note.entiry;

import java.io.Serializable;

public class ActivityNote implements Serializable{
	private static final long serialVersionUID = 1L;
	
	 private String cn_note_activity_id;
	 private String cn_activity_id;
	 private String cn_note_id;
	 private Long cn_note_activity_up;
	 private Long cn_note_activity_down;
	 private String cn_note_activity_title;
	 private String cn_note_activity_body;
	 /**
	 * @return the cn_note_activity_id
	 */
	public String getCn_note_activity_id() {
		return cn_note_activity_id;
	}
	/**
	 * @param cn_note_activity_id the cn_note_activity_id to set
	 */
	public void setCn_note_activity_id(String cn_note_activity_id) {
		this.cn_note_activity_id = cn_note_activity_id;
	}
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
	 * @return the cn_note_activity_up
	 */
	public Long getCn_note_activity_up() {
		return cn_note_activity_up;
	}
	/**
	 * @param cn_note_activity_up the cn_note_activity_up to set
	 */
	public void setCn_note_activity_up(Long cn_note_activity_up) {
		this.cn_note_activity_up = cn_note_activity_up;
	}
	/**
	 * @return the cn_note_activity_down
	 */
	public Long getCn_note_activity_down() {
		return cn_note_activity_down;
	}
	/**
	 * @param cn_note_activity_down the cn_note_activity_down to set
	 */
	public void setCn_note_activity_down(Long cn_note_activity_down) {
		this.cn_note_activity_down = cn_note_activity_down;
	}
	/**
	 * @return the cn_note_activity_title
	 */
	public String getCn_note_activity_title() {
		return cn_note_activity_title;
	}
	/**
	 * @param cn_note_activity_title the cn_note_activity_title to set
	 */
	public void setCn_note_activity_title(String cn_note_activity_title) {
		this.cn_note_activity_title = cn_note_activity_title;
	}
	/**
	 * @return the cn_note_activity_body
	 */
	public String getCn_note_activity_body() {
		return cn_note_activity_body;
	}
	/**
	 * @param cn_note_activity_body the cn_note_activity_body to set
	 */
	public void setCn_note_activity_body(String cn_note_activity_body) {
		this.cn_note_activity_body = cn_note_activity_body;
	}
}
