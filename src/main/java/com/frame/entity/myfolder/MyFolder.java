package com.frame.entity.myfolder;

import java.util.List;

import com.frame.entity.myfile.MyFile;
import com.frame.entity.user.User;


public class MyFolder {
	
	private Integer id;
	
	public String folderName;
	
	public String extrcode;
	
	public User user;
	
	public List<MyFile> myFiles;
	
	public List<MyFolder> myFolders;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getExtrcode() {
		return extrcode;
	}

	public void setExtrcode(String extrcode) {
		this.extrcode = extrcode;
	}

	public List<MyFile> getMyFiles() {
		return myFiles;
	}

	public void setMyFiles(List<MyFile> myFiles) {
		this.myFiles = myFiles;
	}

	public List<MyFolder> getMyFolders() {
		return myFolders;
	}

	public void setMyFolders(List<MyFolder> myFolders) {
		this.myFolders = myFolders;
	}
	
	
}
