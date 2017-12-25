package com.frame.service.logService.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.dao.logDao.LogDao;
import com.frame.entity.log.Log;
import com.frame.entity.user.User;
import com.frame.service.logService.LogService;

@Service("logService")
public class LogServiceBean implements LogService{

	@Autowired
	private LogDao logDao;

	@Override
	public Log saveLog(Log log, HttpServletRequest request) {
		try {
			this.logDao.saveLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Log> getPageList(Integer pageIndex,Integer pageSize, HttpServletRequest request){
		try {
			return this.logDao.getPageList(pageIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int getTotalItems(HttpServletRequest request){
		try {
			return this.logDao.getTotalItems();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void saveLog( HttpServletRequest request,String operation){
		try {
			Log log = new Log();
			log.setOperateDate(new Date());
			log.setOperateUser(((User)request.getSession(false).getAttribute("user")));
			log.setOperation(operation);
			//记录日志
			logDao.saveLog(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
