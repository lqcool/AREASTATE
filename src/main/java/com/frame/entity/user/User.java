package com.frame.entity.user;

import com.frame.entity.anouncement.Anouncement;

public class User {
	private Integer id;
	
	private Long eid;
	
	private String userName;
	
	private String address;
	
	private String tel;  
	
	private String email;
	
	private String loginNo;
	
	private String loginPwd;  
    
	private String employeeNo; 
	
	private String role;
	
	private String roleName;
	
	private Anouncement noReadAnouncement;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Anouncement getNoReadAnouncement() {
		return noReadAnouncement;
	}

	public void setNoReadAnouncement(Anouncement noReadAnouncement) {
		this.noReadAnouncement = noReadAnouncement;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
