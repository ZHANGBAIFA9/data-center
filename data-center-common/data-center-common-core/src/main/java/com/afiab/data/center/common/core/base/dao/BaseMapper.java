package com.afiab.data.center.common.core.base.dao;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/24 11:06
 * @Description:
 */
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>, InsertListMapper<T>, ConditionMapper<T> {
}
