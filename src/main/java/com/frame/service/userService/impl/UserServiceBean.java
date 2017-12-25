package com.frame.service.userService.impl;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.frame.dao.logDao.LogDao;
import com.frame.dao.userDao.UserDao;
import com.frame.entity.log.Log;
import com.frame.entity.user.User;
import com.frame.service.userService.UserService;
import com.frame.util.ConfigUtil;
import com.frame.util.PropertyUtil;

@Service("userService")
@SessionAttributes({"loginNo"}) 
public class UserServiceBean implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private LogDao logDao;

	@Override
	public Map<String, Object> saveUser(User user, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			user.setEid(System.currentTimeMillis());
			User existUser = this.userDao.findUserByLoginNo(user.getLoginNo());
			if(existUser==null){
				userDao.saveUser(user);
				createUserDir(user.getEid()+"");
				resultMap.put("state", "success");
				resultMap.put("success", "注册成功！");
			}else{
				resultMap.put("state", "error");
				resultMap.put("error", "该登陆账号已经使用！");
				System.out.println("该登陆账号已经使用！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public User updateUser(User user, HttpServletRequest request) {
		try {
			userDao.updateUser(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteUser(Long userId, HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserById(Long userId, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByLoginNo(String loginNo, HttpServletRequest request){
		try {
			return this.userDao.findUserByLoginNo(loginNo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Object> checkLoginUser(User user,HttpServletRequest request){
		Map<String, Object> mesMap = new HashMap<String, Object>();
		User extU = this.findUserByLoginNo(user.getLoginNo(),request);
		if(extU == null){
			mesMap.put("mes", "用户名不存在");
			mesMap.put("state", false);
		}
		else if(user.getLoginPwd() == user.getLoginPwd()){
			HttpSession session = request.getSession(true);
			session.setAttribute("user", extU);
			//sesison失效时间1分钟
			session.setMaxInactiveInterval(15*60);
			//处理密码
			extU.setLoginPwd("************");
			//当前用户
			mesMap.put("mes", extU);
			//设置登陆状态
			mesMap.put("state", true);
		}
		else{
			mesMap.put("mes", "密码错误");
			mesMap.put("state", false);
		}
		return mesMap;
	}

	@Override
	public User findUserById(Integer id, HttpServletRequest request) {
		try {
			return this.userDao.findUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * TODO:简略描述方法需要做什么
	 * @return void
	 * @author AbnerLi
	 * @time 2017年12月18日
	 */
	@Override
	public void loginOut(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		session.invalidate();
	}

	public void saveLog( HttpServletRequest request,String operation){
		try {
			Log log = new Log();
			log.setOperateDate(new Date());
			log.setOperateUser(((User)request.getSession(false).getAttribute("user")));
			log.setOperation(operation);
			//记录日志
			logDao.saveLog(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * TODO:创建用户文件夹
	 * @return boolean
	 * @author AbnerLi
	 * @time 2017年12月17日
	 */
	private boolean createUserDir(String code){
		boolean flag = false;
		try {
			String baseDir = getUserBaseDir();
			String realUserDir = baseDir + "\\" + code;
			File folder = new File(realUserDir);
			if(!folder.exists()){
				flag = folder.mkdir();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return flag;
	}

	/**
	 * TODO:获取用户基础目录
	 * @return String
	 * @author AbnerLi
	 * @time 2017年12月17日
	 */
	private String getUserBaseDir() throws Exception{
		//Properties properties = ConfigUtil.readConfigs("sysconfig.properties");
		String userBasePath = PropertyUtil.getProperty("userbasedir");//properties.getProperty("userbasedir");
		if(userBasePath==null || userBasePath==""){
			throw new Exception("请在sysconfig.properties文件配置userbasedir(用户文件基础目录)");
		}
		return userBasePath;
	}

}
