package com.afiab.data.center.common.core.utils;

import cn.hutool.core.util.StrUtil;
import com.afiab.data.center.common.core.constant.Constants;
import com.afiab.data.center.common.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 15:52
 * @Description:
 */
@Slf4j
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

    public static String getCurrentOrgCode() {
        Object object = get(Constants.CURRENT_ORG_CODE);
        if(StrUtil.isBlankIfStr(object)) {
            throw new BusinessException("接口http header组织为必传参数: orgCode");
        }
        return null == object ? null : (String) object;
    }

    /**
     * 获取当前用户
     *
     * @return
     */
//    public static UserInfoDTO currentUser() {
//        UserInfoDTO user = (UserInfoDTO) RequestHolder.get(Constants.CURRENT_USER);
//        if (null == user) {
//            log.error("Cant get userCode in RequestHolder ...");
//            throw new NullPointerException("当前用户不存在！！");
//        }
//        return user;
//    }

    public static String getCurrUserCode(){
        Object object = get(Constants.USER_CODE);
        if(StrUtil.isBlankIfStr(object)) {
            throw new BusinessException("接口http header组织为必传参数: userCode");
        }
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
