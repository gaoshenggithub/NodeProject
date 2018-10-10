package org.anonymous.note.entiry;

import java.io.Serializable;

public class Share implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cn_share_id;
	private String cn_share_title;
	private String cn_share_body;
	private String cn_note_id;
	/**
	 * @return the cn_share_id
	 */
	public String getCn_share_id() {
		return cn_share_id;
	}
	/**
	 * @param cn_share_id the cn_share_id to set
	 */
	public void setCn_share_id(String cn_share_id) {
		this.cn_share_id = cn_share_id;
	}
	/**
	 * @return the cn_share_title
	 */
	public String getCn_share_title() {
		return cn_share_title;
	}
	/**
	 * @param cn_share_title the cn_share_title to set
	 */
	public void setCn_share_title(String cn_share_title) {
		this.cn_share_title = cn_share_title;
	}
	/**
	 * @return the cn_share_body
	 */
	public String getCn_share_body() {
		return cn_share_body;
	}
	/**
	 * @param cn_share_body the cn_share_body to set
	 */
	public void setCn_share_body(String cn_share_body) {
		this.cn_share_body = cn_share_body;
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
}
