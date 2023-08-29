package com.afiab.data.center.common.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:40
 * @Description: 使用本注解的方法不会进行登录拦截验证
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface NoneAuth {
}
