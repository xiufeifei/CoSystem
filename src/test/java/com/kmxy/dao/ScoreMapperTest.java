package com.kmxy.dao;

import com.kmxy.entity.Score;
import com.kmxy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mybatis.xml")
public class ScoreMapperTest {

    @Autowired
    private ScoreMapper scoreMapper;
    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Score score = new Score();
        score.setExperience("三好生");
        score.setUserId(1);
        score.setAttendance(5);
        int i = scoreMapper.insertSelective(score);
        System.out.println(i);

    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectionByCondition() {
        Score score = new Score();
        int i = scoreMapper.selectCountByCondition(score);
        System.out.println(i);
    }

    @Test
    public void selectCountByCondition() {
        Score score = new Score();
        User user = new User();
        score.setUser(user);
        List<Score> scoreList = scoreMapper.selectionByCondition(score);
        scoreList.forEach(item->System.out.println(item));
    }
}