package com.frame.test;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

public class TestReadSysConfig {
	public static void main(String[] args) throws ParserConfigurationException, Exception{  
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL resource = classLoader.getResource("sysconfig.properties");  
        String path = resource.getPath();  
        System.out.println(path);  
        InputStream resourceAsStream = classLoader.getResourceAsStream("sysconfig.properties");  
	}
}
