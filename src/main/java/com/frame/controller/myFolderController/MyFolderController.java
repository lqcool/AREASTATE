package com.frame.controller.myFolderController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.entity.myfolder.MyFolder;
import com.frame.service.myFileService.MyFileService;
import com.frame.service.myFolderService.MyFolderService;

@Controller
@RequestMapping("/myFolderController")
public class MyFolderController {

    @Autowired
    private MyFolderService myFolderService;
    
    @Autowired
    private MyFileService myFileService;

    @RequestMapping(value="/saveMyFolder",method = RequestMethod.POST)
    @ResponseBody
    public MyFolder saveMyFolder(@RequestBody MyFolder myFolder, HttpServletRequest request) {
    	return this.myFolderService.saveMyFolder(myFolder,request);
    }
    
    @RequestMapping(value="/findChildFolderByExtrcode",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> findChildFolderByExtrcode( @RequestParam(value="preExtrcode") String preExtrcode, HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("childFolders", this.myFolderService.findChildFolderByExtrcode(preExtrcode,request));
    	//resultMap.put("childFiles", myFileService.findChildFileByExtrcode(preExtrcode));
    	return resultMap;
    }
    
    @RequestMapping(value="/findChildFolderByExtrcode2",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> findChildFolderByExtrcode2( @RequestParam(value="preExtrcode") String preExtrcode, HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("childFolders", this.myFolderService.findChildFolderByExtrcode(preExtrcode,request));
    	resultMap.put("childFiles", myFileService.findChildFileByExtrcode(preExtrcode,request));
    	return resultMap;
    }
    
    @RequestMapping(value="/findAllFoldersByUserId",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<MyFolder> findAllFoldersByUserId( @RequestParam(value="id") Integer id, HttpServletRequest request){
    	return this.myFolderService.findAllFoldersByUserId(id,request);
    }
    
    @RequestMapping(value="/findFirstLayerfolderFoldersByUserId",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<MyFolder> findFirstLayerfolderFoldersByUserId( @RequestParam(value="id") Integer id, HttpServletRequest request){
    	return this.myFolderService.findFirstLayerfolderFoldersByUserId(id,request);
    }
    
    @RequestMapping(value="/findMyFolderById",method = RequestMethod.POST)
    @ResponseBody
    public MyFolder findMyFolderById(Integer id, HttpServletRequest request) {
		return this.myFolderService.findMyFolderById(id,request);
	}
    
}
