package com.kmxy.service.impl;

import com.kmxy.dao.FilesMapper;
import com.kmxy.entity.Files;
import com.kmxy.service.FilesService;
import com.kmxy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesMapper filesMapper;

    @Override
    public int add(Files files){
        int i = filesMapper.insertSelective(files);
        return i;
    }

    @Override
    public int update(Files files){
        int i = filesMapper.updateByPrimaryKeySelective(files);
        return i;
    }

    @Override
    public boolean delete(Files files){
        return false;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum,Integer pageSize,Files files){
        List<Files> filesList = filesMapper.selectionByCondition(files);
        int count = filesMapper.selectCountByCondition(files);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(filesList);
        return pageBean;
    }

    @Override
    public int deleteByPrimaryKey(int moneyId) {
        int i = filesMapper.deleteByPrimaryKey(moneyId);
        return i;
    }

    @Override
    public Files selectByName(Files file) {
        Files files = filesMapper.selectByName(file);
        return files;
    }

    @Override
    public Files selectById(int id) {
        return filesMapper.selectByPrimaryKey(id);
    }

}