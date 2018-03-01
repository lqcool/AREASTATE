package com.frame.controller.landStateCreaterController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.entity.landDailyState.LandDailyState;
import com.frame.service.landStateCreaterService.LandStateCreaterService;

@Controller
@RequestMapping("/landStateCreaterController")
public class LandStateCreaterController { 
	@Autowired
	private LandStateCreaterService landStateCreaterService; 
    
    @RequestMapping(value="/getLandDailyState",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<LandDailyState> getLandDailyState(@RequestParam("landId") Integer landId,HttpServletRequest request){
    	return this.landStateCreaterService.getLandDailyState(landId,request);
    }
    
}
