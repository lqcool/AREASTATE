package com.frame.entity.log;

import java.util.Date;

import com.frame.entity.user.User;

/**
 * @author AbnerLi
 *
 */
public class Log {
	public Integer id;
	
	public User operateUser;
	
	public Date operateDate;
	
	public String operation;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(User operateUser) {
		this.operateUser = operateUser;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
