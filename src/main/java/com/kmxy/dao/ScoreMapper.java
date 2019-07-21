package com.kmxy.dao;

import com.kmxy.entity.Score;

import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<Score> selectionByCondition(Score score);

    int selectCountByCondition(Score score);

    Score selectByUserId();
}