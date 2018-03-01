package com.frame.service.sysConfigService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.frame.entity.sysconfig.SysConfig;

public interface SysConfigService {
	public SysConfig  saveSysConfig(SysConfig SysConfig, HttpServletRequest request);
	
	public void deleteSysConfig(Integer id, HttpServletRequest request);
	
	public SysConfig findSysConfigById(Integer id, HttpServletRequest request);
	
	public SysConfig updateSysConfig(SysConfig SysConfig, HttpServletRequest request);
	
	public List<SysConfig> findAllSysConfigs(HttpServletRequest request);

	public SysConfig findSysConfigByProperty(String property,
			HttpServletRequest request);

	public List<SysConfig> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition, HttpServletRequest request);

	public int getSearchTotalItems(String searchCondition, HttpServletRequest request);
}
