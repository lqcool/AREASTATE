package com.frame.service.myFileService.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.frame.dao.logDao.LogDao;
import com.frame.dao.myFileDao.MyFileDao;
import com.frame.entity.log.Log;
import com.frame.entity.myfile.MyFile;
import com.frame.entity.user.User;
import com.frame.service.myFileService.MyFileService;

@Service("myFileService")

public class MyFileServiceBean implements MyFileService{

	@Autowired
	private MyFileDao myFileDao;
	@Autowired
	private LogDao logDao;

	@Override
	public MyFile saveMyFile(MyFile myFile, HttpServletRequest request) {
		try {
			if(myFile.getExtrcode() != "" && myFile.getExtrcode()!= null){
				myFile.setExtrcode(myFile.getExtrcode() + createCode(4));
			}
			else{
				myFile.setExtrcode(createCode(4));
			}
			myFileDao.saveMyFile(myFile);
			saveLog(request,"上传文件");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyFile> findAllFiles(HttpServletRequest request) {
		try {
			List<MyFile> fileList = this.myFileDao.findAllFiles();
			saveLog(request,"查询所有文件");
			return fileList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<MyFile> findFilesByFolderId(Integer folderId, HttpServletRequest request) {
		try {
			List<MyFile> fileList =  this.myFileDao.findFilesByFolderId(folderId);
			saveLog(request,"findFilesByFolderId：查询文件");
			return fileList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<MyFile> findChildFileByExtrcode(String preExtrcode, HttpServletRequest request){
		try {
			List<MyFile> fileList =  this.myFileDao.findChildFileByExtrcode(preExtrcode);
			saveLog(request,"findChildFileByExtrcode：查询文件");
			return fileList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public MyFile findFileById(Integer id, HttpServletRequest request){
		try {
			MyFile myfile =  this.myFileDao.findFileById(id);
			this.saveLog(request, "findFileById：根据查找文件");
			return myfile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<MyFile> getPageList(Integer pageIndex,Integer pageSize,String preExtrcode, HttpServletRequest request){
		try {
			List<MyFile> fileList = this.myFileDao.getPageList(pageIndex, pageSize,preExtrcode);
			saveLog(request,"getPageList：分页查询文件");
			return fileList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public int getTotalItems(String preExtrcode, HttpServletRequest request){
		try {
			int totalItems = this.myFileDao.getTotalItems(preExtrcode);
			saveLog(request,"getTotalItems：获取文件夹中文件总数量");
			return totalItems;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public List<MyFile> getSearchPageList(Integer pageIndex,Integer pageSize,String searchCondition,Integer id, HttpServletRequest request){
		try {
			List<MyFile> fileList = this.myFileDao.getSearchPageList(pageIndex, pageSize, searchCondition, id);
			saveLog(request,"getSearchPageList：分页查询文件");
			return fileList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public int getSearchTotalItems(String searchCondition,Integer id, HttpServletRequest request){
		try {
			int totalItems = this.myFileDao.getSearchTotalItems(searchCondition, id);
			saveLog(request,"getSearchTotalItems：");
			return totalItems;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public String createCode(int length) { //length表示生成字符串的长度  
		String base = "0123456789";     
		Random random = new Random();     
		StringBuffer sb = new StringBuffer();     
		for (int i = 0; i < length; i++) {     
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}     
		return sb.toString();     
	}  
	
	public void saveLog( HttpServletRequest request,String operation){
		try {
			Log log = new Log();
			log.setOperateDate(new Date());
			log.setOperateUser(((User)request.getSession(false).getAttribute("user")));
			log.setOperation(operation);
			//记录日志
			logDao.saveLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除文件，首先删除文件，然后删除数据库中的数据
	 */
	@Override
	public int deleteFile(Integer id, HttpServletRequest request) {
		try {
			MyFile obsFile = this.findFileById(id, request);
			if(obsFile!=null){
				boolean deleteFlag = false;
				String path = obsFile.getFilePath();
				File file = new File(path);
				if(file.exists()){
					deleteFlag = file.delete();
				}
				if(deleteFlag){
					int deleteCulums =  this.myFileDao.deleteFile(id);
					saveLog(request, "deleteFile：删除文件");
					return deleteCulums;
				}
				return -1;
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public MyFile updateMyFile(MyFile myFile, HttpServletRequest request) {
		try {
			MyFile tempFile =  this.myFileDao.updateMyFile(myFile);
			saveLog(request, "updateMyFile：更新文件");
			return tempFile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String renameFile(String newFile,Integer id, HttpServletRequest request) {
		try {
			MyFile myFile = this.myFileDao.findFileById(id);
			String folderPath = myFile.getFilePath().substring(0, myFile.getFilePath().lastIndexOf('\\'));
			boolean renameFlag = false;
			File file = new File(myFile.getFilePath());
			if(file.exists()){
				String newFilePath = folderPath + "\\" + newFile;
				renameFlag = file.renameTo(new File(newFilePath));
			}
			if(renameFlag){
				myFile.setFilePath(folderPath + "\\" + newFile);
				myFile.setFileName(newFile);
				this.updateMyFile(myFile, request);
				saveLog(request, "renameFile：重命名文件");
				return "success";
			}
			return "fail";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

}
