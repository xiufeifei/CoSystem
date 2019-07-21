package com.kmxy.dao;

import com.kmxy.entity.Notice;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    int selectCountByCondition(Notice notice);

    List<Notice> selectAll();

    List<Notice> selectionByCondition(Notice notice);
}