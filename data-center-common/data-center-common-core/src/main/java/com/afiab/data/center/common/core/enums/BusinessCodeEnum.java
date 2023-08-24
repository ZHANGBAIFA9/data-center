package com.afiab.data.center.common.core.enums;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 14:40
 * @Description:
 */
public enum BusinessCodeEnum {
    /**
     * common 001 - 099
     */
    FAILURE("001", "操作失败"),
    LOCKED("002", "处理中，请勿重复请求"),
    THREAD_POLL_FULL("003", "系统资源不足，请稍后"),
    ILLEGAL_PARAMETER("004", "请求参数非法"),
    /**
     * 系统异常编码
     */
    REQ_INTERFACE_ERROR("500", "请求接口异常"),
    UNAUTHORIZED("401", "未授权"),
    UNKNOWN_ERROR("999", "未知错误"),


    /**
     * manager系统 100 - 199
     */
    AUDIT_ITEM_EMPTY("100", "审批项为空"),
    AUDIT_ID_EMPTY("101", "审批项为空"),
    ;

    BusinessCodeEnum(String code, String msg) {
        this.code = /*CodeManager.SystemCode.CODE_PALLAS  + */code;
        this.msg = msg;
    }

    /**
     * 响应码
     */
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BussCodeEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
