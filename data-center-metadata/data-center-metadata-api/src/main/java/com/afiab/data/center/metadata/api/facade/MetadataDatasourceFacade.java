package com.afiab.data.center.metadata.api.facade;

import com.afiab.data.center.common.core.base.domain.R;
import com.afiab.data.center.metadata.api.constant.Swagger2Config;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/9/7 15:09
 * @Description: 对外提供元数据接口
 */
@Api(tags = {Swagger2Config.DATASOURCE_OPEN_API})
@RequestMapping("/open/datasource")
public interface MetadataDatasourceFacade {

    @ApiOperation(value = "获取数据源列表", tags = {Swagger2Config.DATASOURCE_OPEN_API})
    @GetMapping("/find")
    R<List<String>> findDatasource() ;

}
