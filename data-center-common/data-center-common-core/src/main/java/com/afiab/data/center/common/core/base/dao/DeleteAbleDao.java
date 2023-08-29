package com.afiab.data.center.common.core.base.dao;

import tk.mybatis.mapper.annotation.LogicDelete;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 13:59
 * @Description:
 */
public class DeleteAbleDao extends BaseDao {
    @LogicDelete
    private Integer isDel;

    public Integer getIsDel() {
        return isDel;
    }

    public DeleteAbleDao setIsDel(Integer isDel) {
        this.isDel = isDel;
        return this;
    }
}
