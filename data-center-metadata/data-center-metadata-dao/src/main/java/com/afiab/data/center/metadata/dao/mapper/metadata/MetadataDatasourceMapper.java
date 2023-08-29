package com.afiab.data.center.metadata.dao.mapper.metadata;

import com.afiab.data.center.common.core.base.dao.BaseMapper;
import com.afiab.data.center.metadata.dao.mapper.entity.MetadataDatasourcePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 14:27
 * @Description:
 */
@Mapper
@Repository
public interface MetadataDatasourceMapper extends BaseMapper<MetadataDatasourcePO> {
}
