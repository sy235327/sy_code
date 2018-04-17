package com.demo.utils;

import java.util.UUID;



/**
 * 工具类(存放代码较少的函数工具类)
 */
public class CommonsUtils {
    /**
     * 获取一个验证码
     * @return 返回一个验证码
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
