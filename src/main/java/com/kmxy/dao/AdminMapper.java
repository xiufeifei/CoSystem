package com.kmxy.dao;

import com.kmxy.entity.Admin;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);
    Admin selectByAccount(String Account);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectionByCondition(Admin admin);

    int selectCountByCondition(Admin admin);

    List<Admin> selectAll();
}