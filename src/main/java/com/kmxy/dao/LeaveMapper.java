package com.kmxy.dao;

import com.kmxy.entity.Leave;

import java.util.List;

public interface LeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);

    List<Leave> selectionByCondition(Leave leave);

    int selectCountByCondition(Leave leave);
}