package com.frame.service.anouncementService.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.dao.anouncementDao.AnouncementDao;
import com.frame.dao.logDao.LogDao;
import com.frame.dao.userDao.UserDao;
import com.frame.entity.anouncement.Anouncement;
import com.frame.entity.user.User;
import com.frame.service.anouncementService.AnouncementService;

@Service("anouncementService")
public class AnouncementServiceBean implements AnouncementService{

	@Autowired
	private AnouncementDao anouncementDao;
	@Autowired
	private LogDao logDao;
	@Autowired
	private UserDao userDao;


	/**
	 * 保存公告的同时也就是发布公告，公告只有两种状态，可发布和已发布状态
	 */
	@Override
	public boolean saveAnouncement(Anouncement anouncement, HttpServletRequest request) {
		try {
			anouncement.setInputDate(new Date());
			anouncement.setUser((User)request.getSession().getAttribute("user"));
			//设置发布日期
			anouncement.setPublishDate(new Date());
			//设置公告状态为已发布
			anouncement.setAnouncementState("已发布");
			//撤回其它已发布的公告
			this.anouncementDao.updateAnouncementState("可发布");
			
			boolean result =  anouncementDao.saveAnouncement(anouncement);
			
			//查找刚保存的数据
			List<Anouncement> savedAnouncements = this.anouncementDao.findAnouncementByState("已发布");
			
			Anouncement savedAnouncement = savedAnouncements.get(0);
			
			//发布公告到每个用户
			userDao.publishAnouncementToUser(savedAnouncement.getId(),anouncement.getUser().getId());
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAnouncement(Anouncement anouncement, HttpServletRequest request) {
		try {
			return anouncementDao.updateAnouncement(anouncement);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAnouncement(Integer id, HttpServletRequest request) {
		try {
			return this.anouncementDao.deleteAnouncement(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Anouncement findAnouncementById(Integer id, HttpServletRequest request) {
		try {
			return this.anouncementDao.findAnouncementById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Anouncement> findAllAnouncements(HttpServletRequest request) {
		try {
			return this.anouncementDao.findAllAnouncements();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean updateAnouncementState(String state,HttpServletRequest request){
		try {
			return this.anouncementDao.updateAnouncementState(state);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateAnouncementStateById(Integer id,String state){
		try {
			return this.anouncementDao.updateAnouncementStateById(id, state);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Anouncement> findAnouncementByState(String state){
		try {
			return this.anouncementDao.findAnouncementByState(state);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Anouncement> getSearchPageList(Integer pageIndex,
			Integer pageSize, String searchCondition){
		try {
			return this.anouncementDao.getSearchPageList(pageIndex, pageSize, searchCondition);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int getSearchTotalItems(String searchCondition){
		try {
			int totalItems = this.anouncementDao.getSearchTotalItems(searchCondition);
			return totalItems;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	/**
	 * TODO:发布公告，将已经保存的公告发布
	 * @return boolean
	 * @author 李桥
	 * @time 2018年1月23日
	 */
	@Override
	public boolean publish(Anouncement anouncement, HttpServletRequest request){
		try {
			//撤回其它已发布的公告
			this.anouncementDao.updateAnouncementState("可发布");
			//设置发布日期
			anouncement.setPublishDate(new Date());
			
			anouncement.setAnouncementState("已发布");
			//更新
			this.anouncementDao.updateAnouncement(anouncement);
			//发布公告到每个用户，除了自己的账号
			return userDao.publishAnouncementToUser(anouncement.getId(),anouncement.getUser().getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
