package com.afiab.data.center.metadata.dao.mapper.entity;

import com.afiab.data.center.common.core.base.dao.DeleteAbleDao;
import lombok.*;

import javax.persistence.Table;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 15:49
 * @Description: metadata_region
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "metadata_region")
@EqualsAndHashCode(callSuper = true)
public class MetadataRegionPO extends DeleteAbleDao {
    /** 集群所在城市 */
    private String city ;
    /** 集群所在机房 */
    private String computerRoom ;
    /** 集群名称 */
    private String cluster ;

}
