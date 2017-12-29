package com.frame.test;

import com.frame.util.Md5;

public class TestMD5ENDODE {
	public static void main(String [] args){
		String pwd = "liqiao55";
		System.out.println(Md5.getMd5(pwd));
	}
}
