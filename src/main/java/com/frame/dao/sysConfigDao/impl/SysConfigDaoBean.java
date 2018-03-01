package com.frame.dao.sysConfigDao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.dao.sysConfigDao.SysConfigDao;
import com.frame.entity.land.Land;
import com.frame.entity.sysconfig.SysConfig;

@Repository("sysConfigDao")
public class SysConfigDaoBean implements SysConfigDao{

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.frame.dao.sysConfigDao.SysConfigMapper";
	
	@Override
	public SysConfig saveSysConfig(SysConfig sysConfig) throws Exception {
		String addSql = namespace + ".addSysConfig";
		sqlSessionTemplate.insert(addSql, sysConfig);
		return null;
	}
	
	@Override
	public SysConfig updateSysConfig(SysConfig sysConfig) throws Exception {
		String addSql = namespace + ".updateSysConfig";
		sqlSessionTemplate.insert(addSql, sysConfig);
		return null;
	}

	@Override
	public void deleteSysConfig(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".deleteSysConfig";
		this.sqlSessionTemplate.delete(selectSql, paramMap);
	}
	
	@Override
	public SysConfig findSysConfigById(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".findSysConfigById";
		SysConfig SysConfig = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return SysConfig;
	}
	
	@Override
	public SysConfig findSysConfigByProperty(String property) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("property", property);
		String selectSql = namespace + ".findSysConfigByProperty";
		SysConfig SysConfig = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return SysConfig;
	}
	

	@Override
	public List<SysConfig> findAllSysConfigs() throws Exception {
		String selectSql = namespace + ".findAllSysConfigs";
		List<SysConfig> SysConfigs = this.sqlSessionTemplate.selectList(selectSql);
		return SysConfigs;
	}

	@Override
	public List<SysConfig> getSearchPageList(Integer pageIndex,
			Integer pageSize, String searchCondition)
					throws Exception {
		
		String selectSql = namespace + ".getSearchPageList";
		Map paramMap= new HashMap<String, Object>();
		int startIndex = pageSize * (pageIndex - 1);
		paramMap.put("startIndex", startIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("searchCondition", "%" + searchCondition + "%");
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}

	@Override
	public int getSearchTotalItems(String searchCondition)
			throws Exception {
		String selectSql = namespace + ".getSearchTotalItems";
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("searchCondition", "%" + searchCondition + "%");
		return this.sqlSessionTemplate.selectOne(selectSql,paramMap);
	}
}
