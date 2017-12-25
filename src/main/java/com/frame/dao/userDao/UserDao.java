package com.frame.dao.userDao;

import com.frame.entity.user.User;

public interface UserDao {
	public User saveUser(User user) throws Exception;
	
	public void deleteUser(Long userId) throws Exception;
	
	public User findUserById(Long userId) throws Exception;

	User findUserByLoginNo(String loginNo) throws Exception;

	User findUserById(Integer id) throws Exception;

	User updateUser(User user) throws Exception;
	
	//public List<User> findUserByCondition(String associateFormId,String associateFormName) throws Exception;
}
