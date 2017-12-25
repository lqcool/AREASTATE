package com.frame.entity.myfile;

import java.util.Date;

import com.frame.entity.myfolder.MyFolder;
import com.frame.entity.user.User;


public class MyFile {
	
	private Integer id;
	
	public String fileName;
	
	public String extrcode;
	
	public String fileType;
	
	public Double fileSize;
	
	public String filePath;
	
	public MyFolder myFolder;
	
	public Date uploadDate;
	
	public User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExtrcode() {
		return extrcode;
	}

	public void setExtrcode(String extrcode) {
		this.extrcode = extrcode;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Double getFileSize() {
		return fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public MyFolder getMyFolder() {
		return myFolder;
	}

	public void setMyFolder(MyFolder myFolder) {
		this.myFolder = myFolder;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
	
}
