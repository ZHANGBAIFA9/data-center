package com.afiab.data.center.metadata.server.controller;

import com.afiab.data.center.common.core.base.domain.R;
import com.afiab.data.center.common.core.base.page.PageRespDTO;
import com.afiab.data.center.metadata.api.constant.Swagger2Config;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 14:34
 * @Description:
 */
@Slf4j
@Api(tags = {Swagger2Config.DATASOURCE_API})
@RestController
@RequestMapping("/datasource")
public class MetadataDatasourceController {

    @ApiOperation(value = "分页查询接口")
    @RequestMapping(value = "/query/page", method = RequestMethod.GET)
    public R<PageRespDTO<List<String>>> list() {
        return (R<PageRespDTO<List<String>>>) R.ok(null);
    }
}
