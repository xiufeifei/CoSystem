package com.kmxy.service;

import com.kmxy.entity.User;
import com.kmxy.utils.PageBean;

import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface UserService {

    int add(User user);

    List<User> selectAll();

    int updateByPrimaryKey(User user);


    int deleteByPrimaryKey(Integer id);

    User selectById(int id);

    User selectByAccount(User user);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, User user);

}
