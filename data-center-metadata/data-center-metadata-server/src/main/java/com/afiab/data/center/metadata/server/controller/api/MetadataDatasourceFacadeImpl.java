package com.afiab.data.center.metadata.server.controller.api;

import com.afiab.data.center.common.core.base.domain.R;
import com.afiab.data.center.metadata.api.facade.MetadataDatasourceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/9/7 15:10
 * @Description:
 */
@Slf4j
@RestController
public class MetadataDatasourceFacadeImpl implements MetadataDatasourceFacade {

    @Override
    public R<List<String>> findDatasource() {
        // TODO 完善逻辑
        return R.ok(new ArrayList<>());
    }
}
