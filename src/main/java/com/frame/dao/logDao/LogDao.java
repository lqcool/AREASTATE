package com.frame.dao.logDao;

import java.util.List;

import com.frame.entity.log.Log;

public interface LogDao {
	public Log saveLog(Log log) throws Exception;
	

	Log findLogById(Integer id) throws Exception;

	List<Log> getPageList(Integer pageIndex, Integer pageSize) throws Exception;

	int getTotalItems() throws Exception;
	
/*	public void deleteUser(Long userId) throws Exception;
	
	public User findUserById(Long userId) throws Exception;

	User findUserByLoginNo(String loginNo) throws Exception;*/
	
	//public List<User> findUserByCondition(String associateFormId,String associateFormName) throws Exception;
}
