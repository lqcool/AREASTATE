package com.frame.controller.userController;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.frame.entity.user.User;
import com.frame.service.userService.UserService;

@Controller
@RequestMapping("/userController")
@SessionAttributes({"loginNo"}) 
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
	public Map<String, Object> saveUser(@RequestBody User user, HttpServletRequest request){
		return userService.saveUser(user,request);
	}
	
	@RequestMapping(value="/findUserByLoginNo",method = RequestMethod.POST)
    @ResponseBody
	public User findUserByLoginNo(@RequestBody String loginNo, HttpServletRequest request){
		return this.userService.findUserByLoginNo(loginNo,request);
	}
	
	@RequestMapping(value="/checkLoginUser",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
	public Map<String, Object> checkLoginUser(@RequestBody User user, HttpServletRequest request){
		return this.userService.checkLoginUser(user,request);
	}
	
	@RequestMapping(value="/findUserById",method = RequestMethod.POST)
    @ResponseBody
	public User findUserById(@RequestParam("id") Integer id, HttpServletRequest request) {
		return this.userService.findUserById(id,request);
	}
	
	@RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ResponseBody
	public User updateUser(@RequestBody User user, HttpServletRequest request){
		userService.updateUser(user,request);
		return user;
	}
	
	@RequestMapping(value="/loginOut",method = RequestMethod.POST)
    @ResponseBody
	public void loginOut(HttpServletRequest request){
		this.userService.loginOut(request);
	}
}
