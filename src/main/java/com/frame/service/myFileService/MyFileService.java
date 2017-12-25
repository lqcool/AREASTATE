package com.frame.service.myFileService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.entity.myfile.MyFile;


public interface MyFileService {
	public MyFile saveMyFile(MyFile myFile, HttpServletRequest request);

	public List<MyFile> findAllFiles(HttpServletRequest request);

	List<MyFile> findFilesByFolderId(Integer folderId, HttpServletRequest request);

	List<MyFile> findChildFileByExtrcode(String preExtrcode, HttpServletRequest request);

	List<MyFile> getPageList(Integer pageIndex, Integer pageSize,String preExtrcode, HttpServletRequest request);

	int getTotalItems(String preExtrcode, HttpServletRequest request);

	int deleteFile(Integer id, HttpServletRequest request);

	MyFile findFileById(Integer id, HttpServletRequest request);

	List<MyFile> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition, Integer id, HttpServletRequest request);

	int getSearchTotalItems(String searchCondition, Integer id,
			HttpServletRequest request);

	String renameFile( String newFile, Integer id,
			HttpServletRequest request);

	MyFile updateMyFile(MyFile myFile, HttpServletRequest request);
}
