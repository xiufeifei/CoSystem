package com.kmxy.dao;

import com.kmxy.entity.Files;

import java.util.List;

public interface FilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Files record);

    int insertSelective(Files record);

    Files selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Files record);

    int updateByPrimaryKey(Files record);

    List<Files> selectionByCondition(Files files);

    Files selectByName(Files files);

    int selectCountByCondition(Files files);
}