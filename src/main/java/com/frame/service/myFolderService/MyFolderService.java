package com.frame.service.myFolderService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.frame.entity.myfolder.MyFolder;

public interface MyFolderService {
	public MyFolder saveMyFolder(MyFolder myFolder, HttpServletRequest request);

	List<MyFolder> findChildFolderByExtrcode(String preExtrcode, HttpServletRequest request);

	List<MyFolder> findAllFoldersByUserId(Integer id, HttpServletRequest request);
	
	List<MyFolder> findFirstLayerfolderFoldersByUserId(Integer id, HttpServletRequest request);

	MyFolder findMyFolderById(Integer id, HttpServletRequest request);
	
/*	public void deleteUser(Long userId);
	
	public User findUserById(Long userId);

	User findUserByLoginNo(String loginNo);

	String checkLoginUser(User user);*/
}
