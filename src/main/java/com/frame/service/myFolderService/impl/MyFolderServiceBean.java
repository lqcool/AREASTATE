package com.frame.service.myFolderService.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.dao.logDao.LogDao;
import com.frame.dao.myFolderDao.MyFolderDao;
import com.frame.entity.log.Log;
import com.frame.entity.myfolder.MyFolder;
import com.frame.entity.user.User;
import com.frame.service.myFolderService.MyFolderService;

@Service("myFolderService")
public class MyFolderServiceBean implements MyFolderService{
	
	@Autowired
	private MyFolderDao myFolderDao;
	@Autowired
	private LogDao logDao;
	
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

	@Override
	public MyFolder saveMyFolder(MyFolder myFolder, HttpServletRequest request) {
		try {
			if(myFolder.getExtrcode() != "" && myFolder.getExtrcode()!= null){
				myFolder.setExtrcode(myFolder.getExtrcode() + createCode(4));
			}
			else{
				myFolder.setExtrcode(createCode(4));
			}
			myFolderDao.saveMyFolder(myFolder);
			saveLog(request,"saveMyFolder：新建文件夹");
			return myFolder;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<MyFolder> findChildFolderByExtrcode(String preExtrcode, HttpServletRequest request){
		try {
			List<MyFolder> folderList = this.myFolderDao.findChildFolderByExtrcode(preExtrcode);
			saveLog(request,"findChildFolderByExtrcode：查找子文件夹");
			return folderList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<MyFolder> findAllFoldersByUserId(Integer id, HttpServletRequest request){
		try {
			List<MyFolder> folderList = this.myFolderDao.findAllFoldersByUserId(id);
			saveLog(request,"findAllFoldersByUserId：根据用户Id查询所有文件夹");
			return folderList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<MyFolder> findFirstLayerfolderFoldersByUserId(Integer id, HttpServletRequest request) {
		try {
			List<MyFolder> folderList = this.myFolderDao.findFirstLayerfolderFoldersByUserId(id);
			saveLog(request,"findFirstLayerfolderFoldersByUserId：根据用户Id查询第一层级文件夹");
			return folderList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}  
	
	@Override
	public MyFolder findMyFolderById(Integer id, HttpServletRequest request){
		try {
			MyFolder folder = this.myFolderDao.findMyFolderById(id);
			saveLog(request,"findMyFolderById：根据用户Id查询文件夹");
			return folder;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
