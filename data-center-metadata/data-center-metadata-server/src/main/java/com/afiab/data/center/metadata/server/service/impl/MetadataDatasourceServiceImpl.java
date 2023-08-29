package com.afiab.data.center.metadata.server.service.impl;

import com.afiab.data.center.metadata.dao.mapper.metadata.MetadataDatasourceMapper;
import com.afiab.data.center.metadata.server.service.MetadataDatasourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 14:34
 * @Description:
 */
@Slf4j
@Service
public class MetadataDatasourceServiceImpl implements MetadataDatasourceService {

    private final MetadataDatasourceMapper datasourceMapper ;

    public MetadataDatasourceServiceImpl(MetadataDatasourceMapper datasourceMapper) {
        this.datasourceMapper = datasourceMapper;
    }


}
