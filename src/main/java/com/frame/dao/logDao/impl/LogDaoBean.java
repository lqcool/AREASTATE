package com.frame.dao.logDao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.dao.logDao.LogDao;
import com.frame.entity.log.Log;
import com.frame.entity.myfile.MyFile;
import com.frame.entity.myfolder.MyFolder;

@Repository("logDao")
public class LogDaoBean implements LogDao{

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.frame.dao.logDao.LogMapper";
	
	@Override
	public Log saveLog(Log log) throws Exception {
		String addSql = namespace + ".addLog";
		sqlSessionTemplate.insert(addSql, log);
		return null;
	}
	
	@Override
	public List<Log> getPageList(Integer pageIndex,Integer pageSize) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		int startIndex = pageSize * (pageIndex - 1);
		paramMap.put("startIndex", startIndex);
		paramMap.put("pageSize", pageSize);
		String selectSql = namespace + ".getPageList";
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}
	
	@Override
	public int getTotalItems() throws Exception {
		Map paramMap= new HashMap<String, Object>();
		String selectSql = namespace + ".getTotalItems";
		return this.sqlSessionTemplate.selectOne(selectSql,paramMap);
	}

	@Override
	public List<MyFolder> findAllLogByUserId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log findLogById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
