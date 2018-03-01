package com.frame.entity.anouncement;


import java.util.Date;

import com.frame.entity.user.User;

/**
 * 
 * @author 李桥 
 * @version 1.0
 * <p>公告类</p>
 */
/**
 * @author AbnerLi
 *
 */
public class Anouncement {
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 公告标题
	 */
	private String anouncementTitle;
	
	/**
	 * 公告内容
	 */
	private String anouncementContent;
	/**
	 * 录入时间
	 */
	private Date inputDate;
	/**
	 * 公告发布日期
	 */
	private Date publishDate;
	/**
	 * 公告状态
	 */
	private String anouncementState;
	
	/**
	 * 公告紧急程度
	 */
	private String urgency;
	
	/**
	 * 发布人
	 */
	private User user;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getInputDate() {
		return inputDate;
	}
	
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getAnouncementState() {
		return anouncementState;
	}

	public void setAnouncementState(String anouncementState) {
		this.anouncementState = anouncementState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAnouncementTitle() {
		return anouncementTitle;
	}

	public void setAnouncementTitle(String anouncementTitle) {
		this.anouncementTitle = anouncementTitle;
	}

	public String getAnouncementContent() {
		return anouncementContent;
	}

	public void setAnouncementContent(String anouncementContent) {
		this.anouncementContent = anouncementContent;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	
	
	
}
