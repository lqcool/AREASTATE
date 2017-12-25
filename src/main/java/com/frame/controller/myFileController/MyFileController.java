package com.frame.controller.myFileController;

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

import com.frame.entity.myfile.MyFile;
import com.frame.service.myFileService.MyFileService;

@Controller("myFileController")
@RequestMapping("/myFileController")
public class MyFileController {

    @Autowired
    private MyFileService myFileService;

    @RequestMapping(value="/saveMyFile",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public MyFile saveMyFolder(@RequestBody MyFile myFile, HttpServletRequest request) {
    	System.out.println(myFileService);
    	return this.myFileService.saveMyFile(myFile,request);
    }
    
    
    @RequestMapping(value="/findAllFiles",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<MyFile> findAllFiles(HttpServletRequest request){
    	return this.myFileService.findAllFiles(request);
    }
    
    @RequestMapping(value="/findChildFileByExtrcode",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<MyFile> findChildFileByExtrcode( @RequestParam(value="preExtrcode") String preExtrcode, HttpServletRequest request){
    	return this.myFileService.findChildFileByExtrcode(preExtrcode,request);
    }
    
    @RequestMapping(value="/findFileById",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public MyFile findFileById(@RequestParam(value="id") Integer id, HttpServletRequest request) {
    	return myFileService.findFileById(id, request);
    }
    
    @RequestMapping(value="/findFilesByFolderId",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<MyFile> findFilesByFolderId(@RequestParam(value="id") Integer folderId, HttpServletRequest request) {
    	return this.myFileService.findFilesByFolderId(folderId,request);
    }
    
    @RequestMapping(value="/getPageList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getPageList(@RequestParam(value="pageIndex") Integer pageIndex,@RequestParam(value="pageSize") Integer pageSize,@RequestParam(value="preExtrcode") String preExtrcode, HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("totalItems", this.myFileService.getTotalItems(preExtrcode,request));
    	resultMap.put("pageList", this.myFileService.getPageList(pageIndex, pageSize,preExtrcode,request));
    	return resultMap;
    }
    
    @RequestMapping(value="/getTotalItems",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public int getTotalItems(@RequestParam(value="preExtrcode") String preExtrcode, HttpServletRequest request){
    	return this.myFileService.getTotalItems(preExtrcode,request);
    }
    
    @RequestMapping(value="/getSearchPageList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getSearchPageList(@RequestParam(value="pageIndex") Integer pageIndex,@RequestParam(value="pageSize") Integer pageSize,@RequestParam(value="searchCondition") String searchCondition,Integer id, HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("totalItems", this.myFileService.getSearchTotalItems(searchCondition, id, request));
    	resultMap.put("pageList", this.myFileService.getSearchPageList(pageIndex, pageSize, searchCondition, id, request));
    	return resultMap;
    }
    
    @RequestMapping(value="/getSearchTotalItems",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public int getSearchTotalItems(@RequestParam(value="searchCondition") String searchCondition,Integer id, HttpServletRequest request){
    	return this.myFileService.getSearchTotalItems(searchCondition, id, request);
    }
    
    @RequestMapping(value="/deleteFile",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int deleteFile(@RequestParam(value="id") Integer id, HttpServletRequest request){
    	return this.myFileService.deleteFile(id,request);
    }
    
    @RequestMapping(value="/renameFile",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
	public String renameFile(@RequestParam(value="newFile") String newFile,@RequestParam(value="id") Integer id, HttpServletRequest request) {
		return this.myFileService.renameFile(newFile, id, request);
	}
}
