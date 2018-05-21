package com.mmbaby.base.util.security;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 11:56
 */

import java.lang.reflect.Array;
import java.security.MessageDigest;

/**
 * **********************************************
 * md5 类实现了RSA Data Security, Inc.在提交给IETF
 * 的RFC1321中的MD5 message-digest 算法。
 * ***********************************************
 */

public class MD5Util {
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 根据自己的规则进行MD5加密
     * 例如，现在需求是有字符串传入zhang，xy
     * 其中zhang是传入的字符
     * 然后需要将zhang的字符进行拆分z，和hang，
     * 最后需要加密的字段为zxyhang
     */
    public static String MD5Test(String inStr) {
        String xy = "xy";
        String finalStr = "";
        if (inStr != null) {
            String fStr = inStr.substring(0, 1);
            String lStr = inStr.substring(1, inStr.length());
            finalStr = string2MD5(fStr + xy + lStr);

        } else {
            finalStr = string2MD5(xy);
        }
        return finalStr;
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(string2MD5("12345a"));
        System.out.println(string2MD5("12345a"));
        System.out.println(string2MD5("12345a"));
        System.out.println(string2MD5("12345a"));
        System.out.println(string2MD5("12345a"));
        System.out.println(string2MD5("12345a"));

        System.out.println(string2MD5("a12345"));
        System.out.println(string2MD5("a12345"));
        System.out.println(string2MD5("a12345"));
        System.out.println(string2MD5("a12345"));
    }

}



