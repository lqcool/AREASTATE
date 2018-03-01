package com.frame.dao.sysConfigDao;

import java.util.List;

import com.frame.entity.land.Land;
import com.frame.entity.sysconfig.SysConfig;

public interface SysConfigDao {
	public SysConfig saveSysConfig(SysConfig SysConfig) throws Exception;
	
	public void deleteSysConfig(Integer id) throws Exception;
	
	public SysConfig findSysConfigById(Integer id) throws Exception;

	public SysConfig updateSysConfig(SysConfig SysConfig) throws Exception;
	
	public List<SysConfig> findAllSysConfigs() throws Exception;

	public SysConfig findSysConfigByProperty(String property) throws Exception;

	public List<SysConfig> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition) throws Exception;

	public int getSearchTotalItems(String searchCondition) throws Exception;
}
