package com.afiab.data.center.common.core.constant;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 15:26
 * @Description:
 */
public class Constants {
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    public static final String AT_SIGN = "@";

    public static final String SHARP = "#";

    /**
     * 制表符
     */
    public static final String LINE_TAB = "\t";

    /**
     * 换行符
     */
    public static final String LINE_SEPARATOR = "\r\n";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static final String AUTO_REOMVE_PRE = "true";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "sortField";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "sortOrder";

    /**
     * 是否为管理员
     */
    public static final String IS_ADMIN = "is_admin";

    /**
     * request header
     */
    public static final String AUTHORIZATION = "authStr";

    public static final String USER_NAME = "userName";

    public static final String USER_CODE = "userCode";

    /**
     * 当前组织ID
     */
    public static final String CURRENT_ORG_CODE = "orgCode";

    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 数据资源下载权限默认id码（必须小写以区分）提供给用户管理配置使用,
     */
    public static final String DATA_DOWNLOAD_SRC_ID = "download";

    public static final String DOWNLOAD_FILE = "download_limit";

    // 访问头信息
    public static final String TOKEN = "token";

}
