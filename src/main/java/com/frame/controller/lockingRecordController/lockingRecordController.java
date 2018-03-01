package com.frame.controller.lockingRecordController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.entity.lockingRecord.LockingRecord;
import com.frame.service.lockingRecordService.LockingRecordService;

/**
 * @author chengbangguo
 *2018年1月1日 下午3:12:23 
 */
@Controller
@RequestMapping("/lockingRecordController") 
public class lockingRecordController {
	@Autowired
	private LockingRecordService lockingRecordService;
	
	@RequestMapping(value="/saveLockingRecord",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
	public LockingRecord saveLockingRecord(@RequestBody LockingRecord lockingRecord, HttpServletRequest request){
		return lockingRecordService.saveLockingRecord(lockingRecord,request);
	}
	
	   
    @RequestMapping(value="/saveLockingRecords",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
	public Map<String,Object> saveLockingRecords(@RequestBody ArrayList<LockingRecord> lockingRecords,
			HttpServletRequest request) {
		return this.lockingRecordService.saveLockingRecords(lockingRecords, request);
	}
	
	@RequestMapping(value="/findLockingRecordById",method = RequestMethod.POST)
    @ResponseBody
	public LockingRecord findLockingRecordById(@RequestParam("id") Integer id, HttpServletRequest request) {
		return this.lockingRecordService.findLockingRecordById(id,request);
	}
	
	@RequestMapping(value="/findLockingRecordByCode",method = RequestMethod.POST)
    @ResponseBody
	public List<LockingRecord> findLockingRecordByCode(@RequestParam("code") String code, HttpServletRequest request) {
		return this.lockingRecordService.findLockingRecordByCode(code,request);
	}
	
	@RequestMapping(value="/deleteLockingRecord",method = RequestMethod.POST)
    @ResponseBody
	public void deleteLockingRecord(@RequestParam("id") Integer id, HttpServletRequest request) {
		this.lockingRecordService.deleteLockingRecord(id, request);
	}
	
	@RequestMapping(value="/updateLockingRecord",method = RequestMethod.POST)
    @ResponseBody
	public LockingRecord updateLockingRecord(@RequestBody LockingRecord LockingRecord, HttpServletRequest request){
		return lockingRecordService.updateLockingRecord(LockingRecord,request);
	}
	
    
    @RequestMapping(value="/findAllLockingRecords",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<LockingRecord> findAllLockingRecords(HttpServletRequest request){
    	return this.lockingRecordService.findAllLockingRecords(request);
    }
    
    @RequestMapping(value="/findAllLockingRecordsByUserId",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<LockingRecord> findAllLockingRecordsByUserId(HttpServletRequest request){
    	return this.lockingRecordService.findAllLockingRecordsByUserId(request);
    }
    
    @RequestMapping(value="/updateLockingRecorderState",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public LockingRecord updateLockingRecorderState(@RequestParam("code") String code,@RequestParam("state") String state,HttpServletRequest request){
    	return this.lockingRecordService.updateLockingRecorderState(code,state,request);
    }
    
    @RequestMapping(value="/getSearchPageList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getSearchPageList(@RequestParam(value="pageIndex") Integer pageIndex,@RequestParam(value="pageSize") Integer pageSize,@RequestParam(value="searchCondition") String searchCondition,Integer id, HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("totalItems", this.lockingRecordService.getSearchTotalItems(searchCondition, id, request));
    	resultMap.put("pageList", this.lockingRecordService.getSearchPageList(pageIndex, pageSize, searchCondition, id, request));
    	return resultMap;
    }
    
    @RequestMapping(value="/getSearchTotalItems",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public int getSearchTotalItems(@RequestParam(value="searchCondition") String searchCondition,Integer id, HttpServletRequest request){
    	return this.lockingRecordService.getSearchTotalItems(searchCondition, id, request);
    }
}

