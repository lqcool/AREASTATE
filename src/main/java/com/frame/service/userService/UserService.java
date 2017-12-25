package com.frame.service.userService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.frame.entity.user.User;

public interface UserService {
	public Map<String, Object>  saveUser(User user, HttpServletRequest request);
	
	public void deleteUser(Long userId, HttpServletRequest request);
	
	public User findUserById(Long userId, HttpServletRequest request);

	User findUserByLoginNo(String loginNo, HttpServletRequest request);

	Map<String, Object> checkLoginUser(User user,HttpServletRequest request);

	User findUserById(Integer id, HttpServletRequest request);

	User updateUser(User user, HttpServletRequest request);

	void loginOut(HttpServletRequest request);
}
