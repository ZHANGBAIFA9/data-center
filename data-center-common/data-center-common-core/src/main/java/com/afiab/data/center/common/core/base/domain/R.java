package com.afiab.data.center.common.core.base.domain;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 11:06
 * @Description: 通用返回类
 */
@Data
public class R<T> implements Serializable {

    private String code;
    private String msg;
    private T data;

    private R() {
        this.code = CodeManager.CommonCode.CODE_200;
        this.msg = "success";
    }

    private R(String msg) {
        this.code = CodeManager.CommonCode.CODE_200;
        this.msg = msg;
    }

    private R(T data) {
        this.code = CodeManager.CommonCode.CODE_200;
        this.msg = "success";
        this.data = data;
    }

    private R(String code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    private R(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(BusinessCodeEnum code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public R(BusinessCodeEnum code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public static <T> R<T> error(R r) {
        return new R<T>(r.getCode(), r.getMsg());
    }

    public static <T> R<T> error(BusinessCodeEnum code) {
        return new R<T>(code);
    }

    public static <T> R<T> error(BusinessCodeEnum code, T data) {
        return new R(code, data);
    }

    public static <T> R<T> error(BusinessCodeEnum code, String msg) {
        return new R<T>(code.getCode(), StrUtil.format("{}: {}", code.getMsg(), msg));
    }

    public static <T> R<T> error(String code, String msg) {
        return new R(code, msg);
    }

    public static R<?> error() {
        return error(BusinessCodeEnum.UNKNOWN_ERROR, "未知异常，请联系管理员");
    }

    public static R<?> error(String msg) {
        return error(BusinessCodeEnum.UNKNOWN_ERROR.getCode(), msg != null ? msg : BusinessCodeEnum.UNKNOWN_ERROR.getMsg());
    }

//    public static R<?> error(String code, String msg) {
//        return new R(code, msg);
//    }

    public static R<?> ok() {
        return new R<>();
    }

    public static R<?> ok(String msg) {
        return new R<>(msg);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(data);
    }

    public static <T> R<T> data(T data) {
        return new R<>(data);
    }

    public boolean isOk() {
        return Objects.deepEquals(CodeManager.CommonCode.CODE_200, code);
    }

    public boolean isOkAndData() {
        return Objects.deepEquals(CodeManager.CommonCode.CODE_200, code) && !isOkAndEmpty();
    }

    public boolean isOkAndEmpty() {
        return Objects.deepEquals(CodeManager.CommonCode.CODE_200, code) &&
                (Objects.isNull(data) ||
                        (data instanceof Collection && CollectionUtils.isEmpty((Collection) data)) ||
                        (data instanceof Map && CollectionUtils.isEmpty((Map) data))
                );
    }
}
