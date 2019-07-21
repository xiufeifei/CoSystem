package com.kmxy.service.impl;

import com.kmxy.dao.LeaveMapper;
import com.kmxy.entity.Leave;
import com.kmxy.service.LeaveService;
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
public class LeaveServiceImpl implements LeaveService{

    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public int add(Leave leave){
        return -1;
    }

    @Override
    public boolean update(Leave leave){
        return false;
    }

    @Override
    public boolean delete(Leave leave){
        return false;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum,Integer pageSize,Leave leave){
        List<Leave> leaveList = leaveMapper.selectionByCondition(leave);
        int count = leaveMapper.selectCountByCondition(leave);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(leaveList);
        return pageBean;
    }

}