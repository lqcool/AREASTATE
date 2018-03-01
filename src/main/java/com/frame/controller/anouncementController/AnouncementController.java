package com.frame.controller.anouncementController;

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

import com.frame.entity.anouncement.Anouncement;
import com.frame.service.anouncementService.AnouncementService;

@Controller
@RequestMapping("/anouncementController")
public class AnouncementController {
	@Autowired
	private AnouncementService anouncementService;  
	 
	@RequestMapping(value="/saveAnouncement",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
	public boolean saveAnouncement(@RequestBody Anouncement anouncement, HttpServletRequest request){
		return anouncementService.saveAnouncement(anouncement,request);
	}
	
	@RequestMapping(value="/findAnouncementById",method = RequestMethod.POST)
    @ResponseBody
	public Anouncement findAnouncementById(@RequestParam("id") Integer id, HttpServletRequest request) {
		return this.anouncementService.findAnouncementById(id,request);
	}
	
	@RequestMapping(value="/deleteAnouncement",method = RequestMethod.POST)
    @ResponseBody
	public boolean deleteAnouncement(@RequestParam("id") Integer id, HttpServletRequest request) {
		return this.anouncementService.deleteAnouncement(id, request);
	}
	
	@RequestMapping(value="/updateAnouncement",method = RequestMethod.POST)
    @ResponseBody
	public boolean updateAnouncement(@RequestBody Anouncement anouncement, HttpServletRequest request){
		return anouncementService.updateAnouncement(anouncement,request);
	}
	
	@RequestMapping(value="/publish",method = RequestMethod.POST)
    @ResponseBody
	public boolean publish(@RequestBody Anouncement anouncement, HttpServletRequest request){
		return anouncementService.publish(anouncement,request);
	}
	
    @RequestMapping(value="/findAllAnouncements",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Anouncement> findAllAnouncements(HttpServletRequest request){
    	return this.anouncementService.findAllAnouncements(request);
    }
    
    
    @RequestMapping(value="/getSearchPageList",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getSearchPageList(@RequestParam(value="pageIndex") Integer pageIndex,@RequestParam(value="pageSize") Integer pageSize,@RequestParam(value="searchCondition") String searchCondition, HttpServletRequest request){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("totalItems", this.anouncementService.getSearchTotalItems(searchCondition));
    	resultMap.put("pageList", this.anouncementService.getSearchPageList(pageIndex, pageSize, searchCondition));
    	return resultMap;
    }
    
    @RequestMapping(value="/getSearchTotalItems",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public int getSearchTotalItems(@RequestParam(value="searchCondition") String searchCondition, HttpServletRequest request){
    	return this.anouncementService.getSearchTotalItems(searchCondition);
    }
}
