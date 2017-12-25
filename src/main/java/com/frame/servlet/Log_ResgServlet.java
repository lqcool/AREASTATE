package com.frame.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.controller.userController.UserController;
import com.frame.entity.user.User;
import com.frame.util.ConfigUtil;

/**
 * Servlet implementation class Log_ResgServlet
 */
@WebServlet("/Log_ResgServlet")
public class Log_ResgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log_ResgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		
		String ope = request.getParameter("method");
		//String od = request.getParameter("loginNo");
		System.out.println("访问Log_ResgServlet");
		
		if("login".equals(ope)){
			System.out.println("登陆操作");
			String loginNo = request.getParameter("loginNo");
			String loginPwd = request.getParameter("loginPwd");
			
			UserController userController = new UserController();
			
			User user = userController.findUserByLoginNo(loginNo,request);
			
			if(user!=null){
				System.out.println("用户名或者密码错误");
			}else if(user.getLoginPwd() == loginPwd){
				System.out.println("登陆成功");
			}
		}
		else if("registe".equals(ope)){
			System.out.println("注册操作");
			String loginNo = request.getParameter("loginNo");
			String loginPwd = request.getParameter("loginPwd");
			
			UserController userController = new UserController();
			
			User user = userController.findUserByLoginNo(loginNo,request);
			
			if(user==null){
				User newUser = new User();
				newUser.setEid(System.currentTimeMillis());
				newUser.setLoginNo(loginNo);
				newUser.setLoginPwd(loginPwd);
				userController.saveUser(newUser,request);
				createUserDir(newUser.getEid()+"");
			}else{
				System.out.println("该登陆账号已经使用！");
			}
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
		Properties properties = ConfigUtil.readConfigs("sysconfig.properties");
		String userBasePath = properties.getProperty("userbasedir");
		if(userBasePath==null || userBasePath==""){
			throw new Exception("请在sysconfig.properties文件配置userbasedir(用户文件基础目录)");
		}
		return userBasePath;
	}
}
