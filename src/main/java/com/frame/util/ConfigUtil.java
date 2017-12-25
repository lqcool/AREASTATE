package com.frame.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取配置文件工具类
 * @author AbnerLi
 *
 */
public class ConfigUtil {
	private static Properties properties = new Properties();
	public static Properties readConfigs(String configFileName){
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			InputStream resourceAsStream = classLoader.getResourceAsStream(configFileName);  
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public static void main(String [] args){
	    Properties properties = ConfigUtil.readConfigs("sysconfig.properties");
        String userBasePath = properties.getProperty("userbasedir");
        System.out.println(userBasePath);
	}
}
