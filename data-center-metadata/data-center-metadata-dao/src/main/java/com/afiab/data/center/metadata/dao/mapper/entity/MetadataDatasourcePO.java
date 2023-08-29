package com.afiab.data.center.metadata.dao.mapper.entity;

import com.afiab.data.center.common.core.base.dao.DeleteAbleDao;

import javax.persistence.Table;
import lombok.*;
/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 13:53
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "metadata_datasource")
@EqualsAndHashCode(callSuper = true)
public class MetadataDatasourcePO extends DeleteAbleDao {
    /** 数据源名称 */
    private String datasourceName ;
}
