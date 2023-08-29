package com.afiab.data.center.common.core.base.handler;


import com.afiab.data.center.common.core.annotation.NoneAuth;
import com.afiab.data.center.common.core.base.domain.R;
import com.afiab.data.center.common.core.constant.Constants;
import com.afiab.data.center.common.core.enums.BusinessCodeEnum;
import com.afiab.data.center.common.core.utils.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 12:34
 * @Description:
 */
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 指定请求资源路径跳过校验,不在此处做校验，统一到webMVCConfig管理
//        if (request.getRequestURI().contains("xxx")) {
//            return true;
//        }
        // 如果被@NoneAuth注解代表不需要登录验证，直接通过
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(NoneAuth.class) != null) {
            return true;
        }
        Class<?> declaringClass = handlerMethod.getMethod().getDeclaringClass();
        if (declaringClass.getAnnotation(NoneAuth.class) != null) {
            return true;
        }
        // 获取token 通过redis 获取当前登录用户信息，不在此处校验token，功能抽取到统一模块进行校验登录token
        String token = request.getHeader(Constants.TOKEN);
        String userCode = request.getHeader(Constants.USER_CODE);
        String userName = request.getHeader(Constants.USER_NAME);
        if (StringUtils.isNotBlank(userCode)){
            request.setAttribute(Constants.USER_CODE, userCode);
            RequestHolder.set(Constants.USER_CODE, userCode);
        }
        if (StringUtils.isNotBlank(userName)) {
            try {
                userName = new String(userName.getBytes("ISO8859-1"), StandardCharsets.UTF_8);
            } catch (UnsupportedEncodingException e) {
                log.info("warn", e);
            }
            RequestHolder.set(Constants.USER_NAME, userName);
        }
        //针对获取到的请求头信息进行校验，如果参数为空，拦截返回false
        if(Objects.isNull(RequestHolder.getCurrentUserCode())||
                Objects.isNull(RequestHolder.getCurrentUsername())){
            String authStr = request.getHeader(Constants.AUTHORIZATION);
            log.info("authStr-验证未通过!!! ,authStr : [ {} ],userName:[{}],userCode:[{}]", authStr,userName,userCode);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(JsonUtils.obj2String(R.error(BusinessCodeEnum.HEADER_INFO_NOT_FOUND)));
            return false ;
        }

        log.info("LoginInterceptor.preHandle, token:{}, userCode:{}, userName:{}, reqHeader UserCode: {}", token , userCode , userName , request.getAttribute(Constants.USER_CODE));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 方法执行成功后移除缓存用户信息
        RequestHolder.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
