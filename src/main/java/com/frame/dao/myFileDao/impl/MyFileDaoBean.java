package com.frame.dao.myFileDao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.dao.myFileDao.MyFileDao;
import com.frame.entity.myfile.MyFile;
import com.frame.entity.myfolder.MyFolder;

@Repository("myFileDao")
public class MyFileDaoBean implements MyFileDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static final String namespace = "com.frame.dao.myFileDao.MyFileMapper";

	@Override
	public MyFile saveMyFile(MyFile myFile) throws Exception {
		String addSql = namespace + ".addMyFile";
		sqlSessionTemplate.insert(addSql, myFile);
		return null;
	}
	
	@Override
	public MyFile updateMyFile(MyFile myFile) throws Exception {
		String updateSql = namespace + ".updateMyFile";
		sqlSessionTemplate.update(updateSql,myFile);
		return null;
	}

	@Override
	public List<MyFile> findAllFiles() throws Exception {
		String selectSql = namespace + ".findAllFiles";
		return this.sqlSessionTemplate.selectList(selectSql);
	}
	
	@Override
	public MyFile findFileById(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".findFileById";
		return this.sqlSessionTemplate.selectOne(selectSql, paramMap);
	}

	@Override
	public List<MyFile> findFilesByFolderId(Integer folderId) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", folderId);
		String selectSql = namespace + ".findFilesByFolderId";
		return this.sqlSessionTemplate.selectList(selectSql);
	}
	
	
	@Override
	public List<MyFile> findChildFileByExtrcode(String preExtrcode)
			throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("preExtrcode", preExtrcode + "____");
		String selectSql = namespace + ".findChildFileByExtrcode";
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}
	
	@Override
	public List<MyFile> getPageList(Integer pageIndex,Integer pageSize,String preExtrcode) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		int startIndex = pageSize * (pageIndex - 1);
		paramMap.put("startIndex", startIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("preExtrcode", preExtrcode + "____");
		String selectSql = namespace + ".getPageList";
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}
	
	@Override
	public List<MyFile> getSearchPageList(Integer pageIndex,Integer pageSize,String searchCondition,Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		int startIndex = pageSize * (pageIndex - 1);
		paramMap.put("startIndex", startIndex);
		paramMap.put("pageSize", pageSize);
		paramMap.put("searchCondition", "%" + searchCondition + "%");
		paramMap.put("user",  id);
		String selectSql = namespace + ".getSearchPageList";
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}
	
	@Override
	public int getTotalItems(String preExtrcode) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("preExtrcode", preExtrcode + "____");
		String selectSql = namespace + ".getTotalItems";
		return this.sqlSessionTemplate.selectOne(selectSql,paramMap);
	}
	
	@Override
	public int getSearchTotalItems(String searchCondition,Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("searchCondition", "%" + searchCondition + "%");
		paramMap.put("user", id);
		String selectSql = namespace + ".getSearchTotalItems";
		return this.sqlSessionTemplate.selectOne(selectSql,paramMap);
	}
	
	@Override
	public int deleteFile(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".deleteFile";
		return this.sqlSessionTemplate.delete(selectSql, paramMap);
	}
}
