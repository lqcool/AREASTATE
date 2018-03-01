package com.frame.dao.anouncementDao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.dao.anouncementDao.AnouncementDao;
import com.frame.entity.anouncement.Anouncement;
import com.frame.entity.lockingRecord.LockingRecord;

@Repository("anouncementDao")
public class AnouncementDaoBean implements AnouncementDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.frame.dao.anouncementDao.AnouncementMapper";

	@Override
	public boolean saveAnouncement(Anouncement Anouncement) throws Exception {
		String addSql = namespace + ".addAnouncement";
		int result = sqlSessionTemplate.insert(addSql, Anouncement);
		return (result > 0);
	}

	@Override
	public boolean updateAnouncement(Anouncement Anouncement) throws Exception {
		String addSql = namespace + ".updateAnouncement";
		int result = sqlSessionTemplate.insert(addSql, Anouncement);
		return (result > 0);
	}

	@Override
	public boolean deleteAnouncement(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".deleteAnouncement";
		int result = this.sqlSessionTemplate.delete(selectSql, paramMap);
		return (result > 0);
	}

	@Override
	public Anouncement findAnouncementById(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".findAnouncementById";
		Anouncement Anouncement = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return Anouncement;
	}

	@Override
	public List<Anouncement> findAllAnouncements() throws Exception {
		String selectSql = namespace + ".findAllAnouncements";
		List<Anouncement> Anouncements = this.sqlSessionTemplate.selectList(selectSql);
		return Anouncements;
	}

	@Override
	public boolean updateAnouncementState(String state) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("state", state);
		String selectSql = namespace + ".updateAnouncementState";
		int result = this.sqlSessionTemplate.update(selectSql,paramMap);
		return (result>1);
	}

	@Override
	public boolean updateAnouncementStateById(Integer id,String state) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("state", state);
		String updateSql = namespace + ".updateAnouncementStateById";
		int result = this.sqlSessionTemplate.update(updateSql,paramMap);
		return (result>1);
	}

	/**
	 * 根据状态查找数据
	 */
	@Override
	public List<Anouncement> findAnouncementByState(String state) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("state", state);
		String selectSql = namespace + ".findAnouncementByState";
		List<Anouncement> results = this.sqlSessionTemplate.selectList(selectSql, paramMap);
		return results;
	}

	@Override
	public List<Anouncement> getSearchPageList(Integer pageIndex,
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
