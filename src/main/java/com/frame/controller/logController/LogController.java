package com.frame.controller.logController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.entity.log.Log;
import com.frame.service.logService.LogService;

@Controller("logController")
@RequestMapping("/logController")
public class LogController {

    @Autowired
    private LogService logService; 

    @RequestMapping(value="/saveLog",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Log saveLog(@RequestBody Log log, HttpServletRequest request) {
    	return this.logService.saveLog(log,request);
    }
    
    @RequestMapping(value="/getPageList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getPageList(@RequestParam(value="pageIndex") Integer pageIndex,@RequestParam(value="pageSize") Integer pageSize, HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("totalItems", this.logService.getTotalItems(request));
    	resultMap.put("pageList", this.logService.getPageList(pageIndex, pageSize,request));
    	return resultMap;
    }
    
    @RequestMapping(value="/getTotalItems",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public int getTotalItems(HttpServletRequest request){
    	return this.logService.getTotalItems(request);
    }
}
