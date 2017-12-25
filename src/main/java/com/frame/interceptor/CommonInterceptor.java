package com.frame.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.frame.entity.user.User;
/**
 * @author AbnerLi
 * 自定义拦截器，拦截请求，并进行登陆是否超时的验证
 */
public class CommonInterceptor extends HandlerInterceptorAdapter{
	private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);  

	/** 
	 * 在业务处理器处理请求之前被调用 
	 * 如果返回false 
	 *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
	 * 如果返回true 
	 *    执行下一个拦截器,直到所有的拦截器都执行完毕 
	 *    再执行被拦截的Controller 
	 *    然后进入拦截器链, 
	 *    从最后一个拦截器往回执行所有的postHandle() 
	 *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
	 * @throws IOException 
	 * @throws ServletException 
	 */  

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException{
		log.info("==============执行顺序: 1、preHandle================");  
		String requestUri = request.getRequestURI();
		//获取的根路径
		String contextPath = request.getContextPath();  
		//求求路径
		String url = requestUri.substring(contextPath.length());
		//静态资源放行
		if(url.endsWith(".js") || url.endsWith(".jpg") || url.endsWith(".png") || url.endsWith(".html") 
				|| url.endsWith(".css")){
			return true;
		}
		//打印
		log.info("requestUri:"+requestUri);  
		log.info("contextPath:"+contextPath);  
		log.info("url:"+url);  
		HttpSession session = request.getSession(true);
		//如果失效，用户在页面操作将会回到登陆页面
		if(session.getAttribute("user") == null){
			response.setStatus(401);
			return false;
		}
		return true;
	} 

	/** 
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	 * 可在modelAndView中加入数据，比如当前时间 
	 */  
	@Override  
	public void postHandle(HttpServletRequest request,  
			HttpServletResponse response, Object handler,  
			ModelAndView modelAndView) throws Exception {  
		log.info("==============执行顺序: 2、postHandle================");  
	}  

	/** 
	 * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
	 */  
	@Override  
	public void afterCompletion(HttpServletRequest request,  
			HttpServletResponse response, Object handler, Exception ex)  
					throws Exception {  
		log.info("==============执行顺序: 3、afterCompletion================");  
	}  
}
