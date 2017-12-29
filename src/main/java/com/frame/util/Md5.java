package com.frame.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author 李桥
 * 工具类，获取给定字符的md5加密后的字符
 *
 */
public class Md5 {
	/**
	 * TODO:获取加密后的字符
	 * @return String
	 * @author 李桥
	 * @time 2017年12月27日
	 */
	public static String getMd5(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(string.getBytes());
			byte hash[] = md.digest();
			StringBuffer sb = new StringBuffer();
			int i = 0;
			for (int offset = 0; offset < hash.length; offset++) {
				i = hash[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(i));
			}
			return sb.toString();
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	//MD5加密方式二
	
//	 // 全局数组
//    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
//            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
//
//    public MD5() {
//    	
//    }

//    // 返回形式为数字跟字符串
//    private static String byteToArrayString(byte bByte) {
//        int iRet = bByte;
//        // System.out.println("iRet="+iRet);
//        if (iRet < 0) {
//            iRet += 256;
//        }
//        int iD1 = iRet / 16;
//        int iD2 = iRet % 16;
//        return strDigits[iD1] + strDigits[iD2];
//    }
//
//    // 返回形式只为数字
//    private static String byteToNum(byte bByte) {
//        int iRet = bByte;
//        System.out.println("iRet1=" + iRet);
//        if (iRet < 0) {
//            iRet += 256;
//        }
//        return String.valueOf(iRet);
//    }
//
//    // 转换字节数组为16进制字串
//    private static String byteToString(byte[] bByte) {
//        StringBuffer sBuffer = new StringBuffer();
//        for (int i = 0; i < bByte.length; i++) {
//            sBuffer.append(byteToArrayString(bByte[i]));
//        }
//        return sBuffer.toString();
//    }
//
//    public static String GetMD5Code(String strObj) {
//        String resultString = null;
//        try {
//            resultString = new String(strObj);
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            // md.digest() 该函数返回值为存放哈希值结果的byte数组
//            resultString = byteToString(md.digest(strObj.getBytes()));
//        } catch (NoSuchAlgorithmException ex) {
//            ex.printStackTrace();
//        }
//        return resultString;
//    }
}
