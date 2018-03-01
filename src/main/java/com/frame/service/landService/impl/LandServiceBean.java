package com.frame.service.landService.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.dao.landDao.LandDao;
import com.frame.dao.logDao.LogDao;
import com.frame.entity.land.Land;
import com.frame.service.landService.LandService;

@Service("landService")
public class LandServiceBean implements LandService{

	@Autowired
	private LandDao landDao;
	@Autowired
	private LogDao logDao;

	@Override
	public Land saveLand(Land land, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			return landDao.saveLand(land);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Land updateLand(Land Land, HttpServletRequest request) {
		try {
			landDao.updateLand(Land);
			return Land;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteLand(Integer id, HttpServletRequest request) {
		try {
			this.landDao.deleteLand(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Land findLandById(Integer id, HttpServletRequest request) {
		try {
			return this.landDao.findLandById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Land> findAllLands(HttpServletRequest request) {
		try {
			return this.landDao.findAllLands();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Land> findAllLandsByState(HttpServletRequest request) {
		try {
			return this.landDao.findAllLandsByState();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Land> getSearchPageList(Integer pageIndex,
			Integer pageSize, String searchCondition, HttpServletRequest request){
		try {
			return this.landDao.getSearchPageList(pageIndex, pageSize, searchCondition);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int getSearchTotalItems(String searchCondition, HttpServletRequest request){
		try {
			int totalItems = this.landDao.getSearchTotalItems(searchCondition);
			return totalItems;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

}
