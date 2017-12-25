package com.frame.service.logService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.frame.entity.log.Log;
import com.frame.entity.myfile.MyFile;


public interface LogService {
	public Log saveLog(Log log, HttpServletRequest request);

	public List<Log> getPageList(Integer pageIndex, Integer pageSize, HttpServletRequest request);

	public int getTotalItems(HttpServletRequest request);

/*	public void deleteUser(Long userId);
	
	public User findUserById(Long userId);

	User findUserByLoginNo(String loginNo);

	String checkLoginUser(User user);*/
}
