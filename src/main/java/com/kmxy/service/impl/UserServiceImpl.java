package com.kmxy.service.impl;

import com.github.pagehelper.PageHelper;
import com.kmxy.dao.UserMapper;
import com.kmxy.entity.User;
import com.kmxy.service.UserService;
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
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user){
        int i = userMapper.insertSelective(user);
        return i;
    }

    @Override
    public List<User> selectAll() {
        List<User> userList = userMapper.selectAll();
        return userList;
    }

    @Override
    public int updateByPrimaryKey(User user){
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }



    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

 

    @Override
    public User selectById(int id) {
        User user1 = userMapper.selectByPrimaryKey(id);
        return user1;
    }

    @Override
    public User selectByAccount(User user) {
        User user1 = userMapper.selectByAccount(user);
        return user1;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum,Integer pageSize,User user){
        List<User> usersList = userMapper.selectionByCondition(user);
        int count = userMapper.selectCountByCondition(user);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(usersList);
        return pageBean;
    }

}