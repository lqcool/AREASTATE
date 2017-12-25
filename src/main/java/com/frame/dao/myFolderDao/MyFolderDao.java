package com.frame.dao.myFolderDao;

import java.util.List;

import com.frame.entity.myfolder.MyFolder;

public interface MyFolderDao {
	public MyFolder saveMyFolder(MyFolder myFolder) throws Exception;
	
	public List<MyFolder> findChildFolderByExtrcode(String preExtrcode) throws Exception;
	
	List<MyFolder> findAllFoldersByUserId(Integer id) throws Exception;
	
	List<MyFolder> findFirstLayerfolderFoldersByUserId(Integer id) throws Exception;

	MyFolder findMyFolderById(Integer id) throws Exception;
	
/*	public void deleteUser(Long userId) throws Exception;
	
	public User findUserById(Long userId) throws Exception;

	User findUserByLoginNo(String loginNo) throws Exception;*/
	
	//public List<User> findUserByCondition(String associateFormId,String associateFormName) throws Exception;
}
