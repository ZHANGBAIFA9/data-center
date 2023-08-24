package com.afiab.data.center.common.core.exception;

import com.afiab.data.center.common.core.base.domain.BusinessCodeEnum;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 11:03
 * @Description:
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -3593919652547622028L;
    private String code;
    private String message;
    private BusinessCodeEnum businessCodeEnum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessCodeEnum getBusinessCodeEnum() {
        return businessCodeEnum;
    }

    public void setBusinessCodeEnum(BusinessCodeEnum businessCodeEnum) {
        this.businessCodeEnum = businessCodeEnum;
    }


    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(BusinessCodeEnum code) {
        super(code.getMsg());
        this.businessCodeEnum = code;
    }

    public BusinessException(BusinessCodeEnum code, String tipData) {
        super(code.getMsg());
        this.businessCodeEnum = code;
        this.message = tipData;
    }

    public BusinessException(BusinessCodeEnum code, Throwable cause) {
        super(code.getMsg(),cause);
        this.businessCodeEnum = code;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
