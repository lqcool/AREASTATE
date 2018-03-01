package com.frame.entity.lockingRecord;

import java.util.Date;

import com.frame.entity.land.Land;
import com.frame.entity.user.User;

/**
 * @author chengbangguo
 *2018年1月1日 上午9:38:07 
 */
public class LockingRecord {
	//主键
	private Integer id;
	
	//申请人
	private User user;
	
	//申请使用日期
	private Date lockDate;
	
	//申请时间段
	private String timeQuantum;
	
	//申请场地
	private Land land;
	
	//提交时间
	private Date submitDate;
	
	//状态
	private String state;
	
	//用户电话
	private String userTel;
	
	//编码
	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getLockDate() {
		return lockDate;
	}

	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	public String getTimeQuantum() {
		return timeQuantum;
	}

	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}

