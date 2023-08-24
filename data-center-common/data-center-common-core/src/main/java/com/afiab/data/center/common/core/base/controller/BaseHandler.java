package com.afiab.data.center.common.core.base.controller;

import com.afiab.data.center.common.core.base.domain.BusinessCodeEnum;
import com.afiab.data.center.common.core.base.domain.R;
import com.afiab.data.center.common.core.base.page.PageRespDTO;
import com.afiab.data.center.common.core.constant.Constants;
import com.afiab.data.center.common.core.exception.BusinessException;
import com.afiab.data.center.common.core.utils.DateUtils;
import com.afiab.data.center.common.core.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.util.*;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 11:05
 * @Description:  web层通用数据处理
 */
public class BaseHandler {
    protected final Logger logger = LoggerFactory.getLogger(BaseHandler.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 获取request
     */
    public HttpServletRequest getRequest() {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse() {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    public String getCurrentUserId() {
        String userCode = getRequest().getHeader(Constants.USER_CODE);
        if (StrUtil.isBlank(userCode)){
            throw new BusinessException(BusinessCodeEnum.ILLEGAL_PARAMETER,"userCode header参数异常");
        }
        return userCode;
    }

//    public UserInfoDTO getCurrentUser() {
//        return RequestHolder.currentUser();
//    }

//    public String getCurrentOrgCode() {
//        String orgCode = RequestHolder.getCurrentOrgCode();
//        if (StrUtil.isBlank(orgCode)){
//            throw new BusinessException(BussCodeEnum.ILLEGAL_PARAMETER,"orgCode header参数异常");
//        }
//        return orgCode;
//    }

    public String getLoginName() {
        return getRequest().getHeader(Constants.USER_NAME);
    }

    /**
     * 响应请求分页数据
     */
    @Deprecated
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected <T> PageRespDTO dataTable(List<T> list) {
        PageRespDTO rspData = new PageRespDTO();
        rspData.setList(list);
        rspData.setPageSize(new PageInfo(list).getPageSize());
        rspData.setTotalCount((int) new PageInfo(list).getTotal());
        rspData.setTotalPage(new PageInfo(list).getPages());
        return rspData;
    }

    @Deprecated
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected R result(List<?> list) {
        PageInfo<?> pageInfo = new PageInfo<>(list);
        Map<String, Object> m = new HashMap<>(3);
        m.put("rows", list);
        m.put("pageNum", pageInfo.getPageNum());
        m.put("total", pageInfo.getTotal());
        return R.ok(m);
    }
}
