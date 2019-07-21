package com.kmxy.dao;

import com.kmxy.entity.News;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News news);

    int insertSelective(News news);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> selectionByCondition(News news);

    List<News> selectionAll();

    int selectCountByCondition(News news);
}