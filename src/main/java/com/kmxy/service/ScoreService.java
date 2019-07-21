package com.kmxy.service;

import com.kmxy.entity.Score;
import com.kmxy.utils.PageBean;

import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface ScoreService {

    int add(Score score);

    Score selectById(Integer scoreId);
    int update(Score score);

    boolean delete(Score score);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Score score);

    int deleteByPrimaryKey(int scoreId);

    Score selectByUserId();
}
