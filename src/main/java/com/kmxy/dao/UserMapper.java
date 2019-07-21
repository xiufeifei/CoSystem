package com.kmxy.dao;

import com.kmxy.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    User selectByAccount(User user);

    int updateByPrimaryKeySelective(User record);

    List<User> selectionByCondition(User user);

    List<User> selectAll();

    int selectCountByCondition(User user);

    int updateByPrimaryKey(User record);

    int batchDelete(Map<String, Object> map);
}