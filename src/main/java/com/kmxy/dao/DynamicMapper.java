package com.kmxy.dao;

import com.kmxy.entity.Dynamic;

import java.util.List;

public interface DynamicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dynamic record);

    int insertSelective(Dynamic record);

    Dynamic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dynamic record);

    int updateByPrimaryKey(Dynamic record);

    List<Dynamic> selectionByCondition(Dynamic dynamic);
    List<Dynamic> selectAll();


    int selectCountByCondition(Dynamic dynamic);
}