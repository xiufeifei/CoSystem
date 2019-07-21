package com.kmxy.dao;

import com.kmxy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mybatis.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        /*User user = new User();
        for (int i=0;i<20;i++){
            user.setId(i);
            user.setAccount("161107410012");
            user.setName("张亮");
            user.setGender((byte) 1);
            user.setBirthday(LocalDateTime.of(2018,12,25,0,0,0));
            user.setPolitic((byte) 1);
            user.setFoster(1);
            user.setBranch("一支部");
            user.setEducation("高中");
            user.setFaculty("信息工程");
            user.setJunior("2015");
            user.setGrades("技科一");
            user.setTell("{18687455413}");
            user.setAdminId(1);
            user.setPlayer((byte) 1);
            user.setState((byte) 1);
            userMapper.insertSelective(user);
        }*/

    }

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        User user = new User();
        user.setUsername("哈哈");
        user.setUaccount("1234567");
        user.setPwd("123456");
        user.setTell("18687454513");
        user.setPolitic((byte) 1);
        user.setState((byte) 1);
        user.setUid(2);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Test
    public void updateByPrimaryKey() {
        User user = new User();
        user.setPolitic((byte) 4);
        user.setUsername("小白白");
        List<User> users = userMapper.selectionByCondition(user);
        users.forEach(item->System.out.println(item));
    }
}