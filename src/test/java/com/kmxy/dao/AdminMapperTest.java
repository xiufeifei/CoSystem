package com.kmxy.dao;

import com.kmxy.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mybatis.xml")
public class AdminMapperTest {
@Autowired
        private AdminMapper adminMapper;
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
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);

    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectionByCondition() {
    }

    @Test
    public void selectCountByCondition() {
        Admin admin = new Admin();
        List<Admin> admins = adminMapper.selectionByCondition(admin);
        admins.forEach(item->System.out.println(item));

    }
}