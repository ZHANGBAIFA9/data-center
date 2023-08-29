package com.afiab.data.center.metadata.server.service.convert;

import com.afiab.data.center.metadata.server.service.convert.qualifier.ExtendMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 17:52
 * @Description:
 */
@Mapper(componentModel = "spring", uses = ExtendMapper.class)
public interface MetadataDatasourceConvert {

    MetadataDatasourceConvert INS = Mappers.getMapper(MetadataDatasourceConvert.class);



}
