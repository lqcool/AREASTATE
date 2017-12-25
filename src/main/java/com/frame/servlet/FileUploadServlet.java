package com.frame.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.frame.entity.myfile.MyFile;
import com.frame.entity.myfolder.MyFolder;
import com.frame.entity.user.User;
import com.frame.service.myFileService.MyFileService;
import com.frame.service.myFolderService.MyFolderService;
import com.frame.util.ConfigUtil;
import com.frame.util.PropertyUtil;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private  MyFileService myFileService;// = new MyFileController();

	@Autowired
	private  MyFolderService myFolderService;

	private static HttpSession session;

	public FileUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("访问FileUploadServlet");
		session = request.getSession(true);
		handAll(request);
	}

	public void handAll(HttpServletRequest request){
		//检查请求是否是multipart/form-data类型
		if(!ServletFileUpload.isMultipartContent(request)){  //不是multipart/form-data类型
			throw new RuntimeException("表单的enctype属性不是multipart/form-data类型！！");
		}

		//创建上传所需要的两个对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory); //解析器依赖于工厂

		//创建容器来接受解析的内容
		List<FileItem> items = new ArrayList<FileItem>();

		//将上传的文件信息放入容器中
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//遍历容器,处理解析的内容;封装两个方法，一个处理普通表单域，一个处理文件的表单域
		for(FileItem item : items){
			if(item.isFormField()){
				handleFormField(item);
			}else{
				handleUploadField(item,request);
			}
		}
	}

	/**
	 * 
	 * TODO:处理表单普通字段
	 * @return void
	 * @author AbnerLi
	 * @time 2017年12月18日
	 */
	private void handleFormField(FileItem item) {
		String fieldName = item.getFieldName(); //得到表单域的name的值
		String value = "";
		try {
			value = item.getString("utf-8");  //得到普通表单域中所输入的值
			session.setAttribute(fieldName, value);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//打印到控制台
		System.out.println("fieldName:"+fieldName+"--value:"+value);
	}

	/**
	 * 
	 * TODO:处理文件
	 * @return String
	 * @author AbnerLi
	 * @time 2017年12月18日
	 */
	private String handleUploadField(FileItem item,HttpServletRequest request) {
		String realFolderPath  = "";
		try {
			User user = (User)request.getSession().getAttribute("user");
			//得到上传文件的文件名
			String fileName = item.getName();
			realFolderPath = PropertyUtil.getProperty("userbasedir") + user.getEid() + "\\" + fileName;
			if(user!=null){
				item.write(new File(realFolderPath));
				myFileService.saveMyFile(createMyFile(item, realFolderPath,request),request);
				System.out.println("文件" + fileName + "上传成功====>>path:" + realFolderPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return realFolderPath;

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

	private File getChildDirectory(String path) {
		Date currTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(currTime);
		File file = new File(path,time);
		if(!file.exists()){
			file.mkdirs();
		}
		return file;
	}

	/**
	 * TODO:创建一个文件实体
	 * @return MyFile
	 * @author AbnerLi
	 * @time 2017年12月4日
	 */
	private MyFile createMyFile(FileItem item,String path,HttpServletRequest request){
		String fileName = item.getName();
		Double fileSize = new BigDecimal((float)item.getSize() / (1024 * 1024)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		String filePath = path;
		String fileType = item.getContentType();
		MyFile myFile = new MyFile();
		myFile.setFileName(fileName);
		myFile.setFileSize(fileSize);
		myFile.setFileType(fileType);
		myFile.setFilePath(filePath);
		User user = (User)request.getSession(false).getAttribute("user");
		MyFolder folder = new MyFolder();
		Integer folderId = Integer.parseInt((String)session.getAttribute("folderId"));
		folder.setId(folderId);
		MyFolder parentFolder = myFolderService.findMyFolderById(folderId,request);
		myFile.setExtrcode(parentFolder.getExtrcode());
		myFile.setMyFolder(folder);
		myFile.setUser(user);
		myFile.setUploadDate(new Date());
		return myFile;
	}

	/**
	 * 重写init方法，使得servlet可以调用SpringMVC中的方法
	 */
	public void init() throws ServletException {  
		super.init();  
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());  
		AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();  
		factory.autowireBean(this);  
	}  
}

