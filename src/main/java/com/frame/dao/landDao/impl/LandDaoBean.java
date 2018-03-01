package com.frame.dao.landDao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.dao.landDao.LandDao;
import com.frame.entity.land.Land;

@Repository("landDao")
public class LandDaoBean implements LandDao{

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.frame.dao.landDao.LandMapper";
	
	@Override
	public Land saveLand(Land Land) throws Exception {
		String addSql = namespace + ".addLand";
		sqlSessionTemplate.insert(addSql, Land);
		return null;
	}
	
	@Override
	public Land updateLand(Land Land) throws Exception {
		String addSql = namespace + ".updateLand";
		sqlSessionTemplate.insert(addSql, Land);
		return null;
	}

	@Override
	public void deleteLand(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".deleteLand";
		this.sqlSessionTemplate.delete(selectSql, paramMap);
	}
	
	@Override
	public Land findLandById(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".findLandById";
		Land land = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return land;
	}

	@Override
	public List<Land> findAllLands() throws Exception {
		String selectSql = namespace + ".findAllLands";
		List<Land> lands = this.sqlSessionTemplate.selectList(selectSql);
		return lands;
	}

	@Override
	public List<Land> findAllLandsByState() throws Exception {
		String selectSql = namespace + ".findAllLandsByState";
		List<Land> lands = this.sqlSessionTemplate.selectList(selectSql);
		return lands;
	}
	
	@Override
	public List<Land> getSearchPageList(Integer pageIndex,
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
