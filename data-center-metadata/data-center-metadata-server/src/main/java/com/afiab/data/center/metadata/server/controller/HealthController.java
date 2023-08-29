package com.afiab.data.center.metadata.server.controller;


import com.afiab.data.center.common.core.annotation.NoneAuth;
import com.afiab.data.center.common.core.base.domain.R;
import com.afiab.data.center.metadata.api.constant.Swagger2Config;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 15:10
 * @Description: 健康检查跳过组件检查，仅校验项目是否正常
 */
@Api(tags = {Swagger2Config.CHECK_API})
@RestController
@RequestMapping("/health")
public class HealthController {
    /**
     * consul 状态检查接口
     * @return
     */
    @NoneAuth
    @RequestMapping(value = "/checkState",method = RequestMethod.GET)
    public R checkState() {
        return R.ok();
    }
}
