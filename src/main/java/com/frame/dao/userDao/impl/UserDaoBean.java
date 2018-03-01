package com.frame.dao.userDao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.dao.userDao.UserDao;
import com.frame.entity.anouncement.Anouncement;
import com.frame.entity.user.User;

@Repository("userDao")
public class UserDaoBean implements UserDao{

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "com.frame.dao.userDao.UserMapper";
	
	@Override
	public User saveUser(User user) throws Exception {
		String addSql = namespace + ".addUser";
		sqlSessionTemplate.insert(addSql, user);
		return null;
	}
	
	@Override
	public User updateUser(User user) throws Exception {
		String addSql = namespace + ".updateUser";
		sqlSessionTemplate.insert(addSql, user);
		return null;
	}

	@Override
	public void deleteUser(Long userId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserById(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User findUserByLoginNo(String loginNo) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("loginNo", loginNo);
		String selectSql = namespace + ".findUserByLoginNo";
		User user = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return user;
	}
	
	@Override
	public User findUserByIdWithMesSmall(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".findUserByIdWithMesSmall";
		User user = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return user;
	}
	
	@Override
	public User findUserById(Integer id) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		String selectSql = namespace + ".findUserById";
		User user = this.sqlSessionTemplate.selectOne(selectSql,paramMap);
		return user;
	}
	
	/**
	 * 发布公告
	 */
	@Override
	public boolean publishAnouncementToUser(Integer anouncementId,Integer userId) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("anouncementId", anouncementId);
		paramMap.put("userId", userId);
		String updateSql = namespace + ".publishAnouncementToUser";
		int result = sqlSessionTemplate.update(updateSql,paramMap);
		return (result > 1);
	}
	
	/**
	 * 用户阅读公告
	 */
	@Override
	public boolean readedAnouncement(String loginNo) throws Exception {
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("loginNo", loginNo);
		String updateSql = namespace + ".readedAnouncement";
		int result = sqlSessionTemplate.update(updateSql,paramMap);
		return (result > 1);
	}
	
	
	@Override
	public List<User> getSearchPageList(Integer pageIndex,
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
	
	/**
	 * TODO设置用户角色
	 * @return boolean
	 * @author 李桥
	 * @time 2018年1月24日
	 */
	@Override
	public boolean updateUserRole(Integer id,String role,String roleName)
			throws Exception {
		String updateSql = namespace + ".updateUserRole";
		Map paramMap= new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("role", role);
		paramMap.put("roleName", roleName);
		int result =  this.sqlSessionTemplate.update(updateSql, paramMap);
		return (result > 1);
	}
}
