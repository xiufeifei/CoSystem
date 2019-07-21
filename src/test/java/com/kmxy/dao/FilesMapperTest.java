package com.kmxy.dao;

import com.kmxy.entity.Files;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mybatis.xml")
public class FilesMapperTest {

    @Autowired
    private FilesMapper filesMapper;

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
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectionByCondition() {
        Files files1 = new Files();
        List<Files> files = filesMapper.selectionByCondition(files1);
        files.forEach(item->System.out.println(item));
    }

    @Test
    public void selectCountByCondition() {
        Files files1 = new Files();
        int i = filesMapper.selectCountByCondition(files1);
        System.out.println(i);
    }
}