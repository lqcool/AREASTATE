package com.frame.dao.myFileDao;

import java.util.List;

import com.frame.entity.myfile.MyFile;

public interface MyFileDao {
	public MyFile saveMyFile(MyFile myFile) throws Exception;

	public List<MyFile> findAllFiles() throws Exception ;

	List<MyFile> findFilesByFolderId(Integer folderId) throws Exception;

	List<MyFile> findChildFileByExtrcode(String preExtrcode) throws Exception;

	List<MyFile> getPageList(Integer pageIndex, Integer pageSize,String preExtrcode)
			throws Exception;

	int getTotalItems(String preExtrcode) throws Exception;

	int deleteFile(Integer id) throws Exception;

	MyFile findFileById(Integer id) throws Exception;

	List<MyFile> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition,Integer id) throws Exception;

	int getSearchTotalItems(String searchCondition, Integer id)
			throws Exception;

	MyFile updateMyFile(MyFile myFile) throws Exception;
	
	
}
