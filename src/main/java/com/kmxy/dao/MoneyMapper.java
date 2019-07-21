package com.kmxy.dao;

import com.kmxy.entity.Money;

import java.util.List;

public interface MoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Money record);

    int insertSelective(Money record);

    Money selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Money record);

    int updateByPrimaryKey(Money record);

    List<Money> selectionByCondition(Money money);

    int selectCountByCondition(Money money);
}