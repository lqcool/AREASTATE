package com.frame.entity.sysconfig;

import java.util.Date;

/**
 * 
 * @author 李桥
 * 系统配置类
 */
public class SysConfig {
	
	public Integer id ;
	/**
	 * 属性
	 */
	public String property;
	
	/**
	 * 值
	 */
	public String value;
	
	/**
	 * 属性类型（这里仅仅包含两个，字符和数值类型）
	 */
	public String type;
	
	public boolean deleteable;
	/**
	 * 配置日期
	 */
	public Date inputDate;
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean getDeleteable() {
		return deleteable;
	}
	public void setDeleteable(boolean deleteable) {
		this.deleteable = deleteable;
	}
	
	
}
