package com.frame.entity.land;

import java.util.Date;

/**
 * 
 * @author 李桥 
 * @version 1.0
 * <p>用地实体类</p>
 */
public class Land {
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 用地名称
	 */
	private String landName;
	/**
	 * 用地面积
	 */
	private Double landAreas;
	/**
	 * 用地编码
	 */
	private String code;
	/**
	 * 录入时间
	 */
	private Date inputDate;
	/**
	 * 用地状态（备选字段）
	 */
	private String landState;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLandName() {
		return landName;
	}
	
	public void setLandName(String landName) {
		this.landName = landName;
	}
	
	public Double getLandAreas() {
		return landAreas;
	}
	
	public void setLandAreas(Double landAreas) {
		this.landAreas = landAreas;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Date getInputDate() {
		return inputDate;
	}
	
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
	public String getLandState() {
		return landState;
	}
	
	public void setLandState(String landState) {
		this.landState = landState;
	}

}
