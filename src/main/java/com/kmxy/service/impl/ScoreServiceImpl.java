package com.kmxy.service.impl;

import com.kmxy.dao.ScoreMapper;
import com.kmxy.entity.Score;
import com.kmxy.service.ScoreService;
import com.kmxy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public int add(Score score){
        int i = scoreMapper.insertSelective(score);
        return i;
    }

    @Override
    public Score selectById(Integer scoreId) {
        Score score = scoreMapper.selectByPrimaryKey(scoreId);
        return score;
    }

    @Override
    public int update(Score score){
        int i = scoreMapper.updateByPrimaryKeySelective(score);
        return i;
    }

    @Override
    public boolean delete(Score score){
        return false;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum,Integer pageSize,Score score){
        List<Score> scoreList = scoreMapper.selectionByCondition(score);
        int count = scoreMapper.selectCountByCondition(score);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(scoreList);
        return pageBean;
    }

    @Override
    public int deleteByPrimaryKey(int scoreId) {
        int i = scoreMapper.deleteByPrimaryKey(scoreId);
        return i;
    }

    @Override
    public Score selectByUserId() {
        return scoreMapper.selectByUserId();
    }

}