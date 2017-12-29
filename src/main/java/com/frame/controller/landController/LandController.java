package com.frame.controller.landController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.entity.land.Land;
import com.frame.service.landService.LandService;

@Controller
@RequestMapping("/landController")
public class LandController {
	@Autowired
	private LandService landService;
	
	@RequestMapping(value="/saveLand",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
	public Land saveLand(@RequestBody Land land, HttpServletRequest request){
		return landService.saveLand(land,request);
	}
	
	@RequestMapping(value="/findLandById",method = RequestMethod.POST)
    @ResponseBody
	public Land findLandById(@RequestParam("id") Integer id, HttpServletRequest request) {
		return this.landService.findLandById(id,request);
	}
	
	@RequestMapping(value="/deleteLand",method = RequestMethod.POST)
    @ResponseBody
	public void deleteLand(@RequestParam("id") Integer id, HttpServletRequest request) {
		this.landService.deleteLand(id, request);
	}
	
	@RequestMapping(value="/updateLand",method = RequestMethod.POST)
    @ResponseBody
	public Land updateLand(@RequestBody Land land, HttpServletRequest request){
		return landService.updateLand(land,request);
	}
	
    
    @RequestMapping(value="/findAllLands",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Land> findAllLands(HttpServletRequest request){
    	return this.landService.findAllLands(request);
    }
    
}
