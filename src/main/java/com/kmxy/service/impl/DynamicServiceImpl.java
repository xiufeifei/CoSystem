package com.kmxy.service.impl;

import com.kmxy.dao.DynamicMapper;
import com.kmxy.entity.Dynamic;
import com.kmxy.service.DynamicService;
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
public class DynamicServiceImpl implements DynamicService{

    @Autowired
    private DynamicMapper dynamicMapper;

    @Override
    public int add(Dynamic dynamic){
        return -1;
    }

    @Override
    public Dynamic selectById(int id) {
        return dynamicMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dynamic> selectAll() {
        return dynamicMapper.selectAll();
    }

    @Override
    public boolean update(Dynamic dynamic){
        return false;
    }

    @Override
    public boolean delete(Dynamic dynamic){
        return false;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum,Integer pageSize,Dynamic dynamic){
        List<Dynamic> dynamicList = dynamicMapper.selectionByCondition(dynamic);
        int count = dynamicMapper.selectCountByCondition(dynamic);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(dynamicList);
        return pageBean;
    }

}