package com.frame.dao.myFolderDao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.dao.myFolderDao.MyFolderDao;
import com.frame.entity.myfolder.MyFolder;

@Repository("myFolderDao")
public class MyFolderDaoBean implements MyFolderDao{

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.frame.dao.myFolderDao.MyFolderMapper";
	
	@Override
	public MyFolder saveMyFolder(MyFolder myFolder) throws Exception {
		String addSql = namespace + ".addMyFolder";
		sqlSessionTemplate.insert(addSql, myFolder);
		return null;
	}

	@Override
	public List<MyFolder> findChildFolderByExtrcode(String preExtrcode)
			throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("preExtrcode", preExtrcode + "____");
		String selectSql = namespace + ".findChildFolderByExtrcode";
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}


	/**
	 * 查询用户一级文件夹
	 */
	@Override
	public List<MyFolder> findFirstLayerfolderFoldersByUserId(Integer id)
			throws Exception {
		Map paramMap= new HashMap<String, Object>();
		//用户的id
		paramMap.put("id", id);
		//一级文件夹
		paramMap.put("extrcode", "____");
		String selectSql = namespace + ".findFoldersByUserId";
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}

	@Override
	public List<MyFolder> findAllFoldersByUserId(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		//用户的id
		paramMap.put("id", id);
		//一级文件夹
		String selectSql = namespace + ".findAllFoldersByUserId";
		return this.sqlSessionTemplate.selectList(selectSql, paramMap);
	}
	
	@Override
	public MyFolder findMyFolderById(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".findMyFolderById";
		MyFolder myFolder = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return myFolder;
	}
}
