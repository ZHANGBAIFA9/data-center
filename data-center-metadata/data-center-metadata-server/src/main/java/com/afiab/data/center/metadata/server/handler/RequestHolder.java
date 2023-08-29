package com.afiab.data.center.metadata.server.handler;

import cn.hutool.core.util.StrUtil;
import com.afiab.data.center.common.core.constant.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 12:38
 * @Description:
 */
public class RequestHolder {

    private final static ThreadLocal<Map<String, Object>> HOLDER = new ThreadLocal<>();

    public static void remove() {
        HOLDER.remove();
    }

    public static void set(String key, Object value) {
        getContext().put(key, value);
    }

    public static Object get(String key) {
        return getContext().get(key);
    }

    /**
     * 获取当前登录用户工号
     * @return
     */
    public static String getCurrentUserCode(){
        Object object = get(Constants.USER_CODE);
        return null == object? null : (String) object;
    }

    /**
     * 获取当前登录用户工号
     * @return 用户工号
     */
    public static String getUserCode(){
        Object object = get(Constants.USER_CODE);
        return null == object? null : (String) object;
    }
    /**
     * 获取当前登录用户姓名
     * @return 用户姓名
     */
    public static String getUserName(){
        Object object = get(Constants.USER_NAME);
        return null == object? null : (String) object;
    }

    /**
     * 获取当前登录用户姓名 张三/25648662
     * @return 用户姓名
     */
    public static String getUserShowInfo(){
        String userName = getUserName();
        String userCode = getUserCode();
        if (StrUtil.isNotEmpty(userName) && StrUtil.isNotEmpty(userCode)){
            return  userName + "/" + userCode;
        } else if (StrUtil.isNotEmpty(userName)){
            return userName;
        } else if (StrUtil.isNotEmpty(userCode)){
            return userCode;
        }
        return null;
    }


    /**
     * 获取当前登录用户姓名
     * @return
     */
    public static String getCurrentUsername(){
        Object object = get(Constants.USER_NAME);
        return null == object? null : (String) object;
    }





    static private Map<String, Object> getContext() {
        Map<String, Object> map = HOLDER.get();
        if (map == null) {
            map = new HashMap<>(8);
            HOLDER.set(map);
        }
        return map;
    }

}
