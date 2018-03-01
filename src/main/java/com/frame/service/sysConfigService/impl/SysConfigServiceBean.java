package com.frame.service.sysConfigService.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.dao.logDao.LogDao;
import com.frame.dao.sysConfigDao.SysConfigDao;
import com.frame.entity.land.Land;
import com.frame.entity.sysconfig.SysConfig;
import com.frame.service.sysConfigService.SysConfigService;

@Service("sysConfigService")
public class SysConfigServiceBean implements SysConfigService{

	@Autowired
	private SysConfigDao sysConfigDao;
	@Autowired
	private LogDao logDao;

	@Override
	public SysConfig saveSysConfig(SysConfig sysConfig, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			sysConfig.setDeleteable(true);
			return this.sysConfigDao.saveSysConfig(sysConfig);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public SysConfig updateSysConfig(SysConfig sysConfig, HttpServletRequest request) {
		try {
			this.sysConfigDao.updateSysConfig(sysConfig);
			return sysConfig;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteSysConfig(Integer id, HttpServletRequest request) {
		try {
			this.sysConfigDao.deleteSysConfig(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public SysConfig findSysConfigById(Integer id, HttpServletRequest request) {
		try {
			return this.sysConfigDao.findSysConfigById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@Override
	public SysConfig findSysConfigByProperty(String property, HttpServletRequest request) {
		try {
			return this.sysConfigDao.findSysConfigByProperty(property);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<SysConfig> findAllSysConfigs(HttpServletRequest request) {
		try {
			return this.sysConfigDao.findAllSysConfigs();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SysConfig> getSearchPageList(Integer pageIndex,
			Integer pageSize, String searchCondition, HttpServletRequest request){
		try {
			return this.sysConfigDao.getSearchPageList(pageIndex, pageSize, searchCondition);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int getSearchTotalItems(String searchCondition, HttpServletRequest request){
		try {
			int totalItems = this.sysConfigDao.getSearchTotalItems(searchCondition);
			return totalItems;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}
	
}
