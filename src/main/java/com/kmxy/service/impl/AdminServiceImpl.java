package com.kmxy.service.impl;

import com.kmxy.dao.AdminMapper;
import com.kmxy.entity.Admin;
import com.kmxy.service.AdminService;
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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int add(Admin admin){
        int i = adminMapper.insert(admin);
        return i;
    }

    @Override
    public boolean update(Admin admin){
        int i = adminMapper.updateByPrimaryKey(admin);
        if (i>0){
            return true;
        }else {
        return false;
        }
    }

    @Override
    public boolean delete(Admin admin){
        int i = adminMapper.updateByPrimaryKey(admin);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Admin selectBy(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin selectByAccount(String account) {
        Admin admin = adminMapper.selectByAccount(account);
        return admin;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum, Integer pageSize, Admin admin){
        List<Admin> adminList = adminMapper.selectionByCondition(admin);
        int count = adminMapper.selectCountByCondition(admin);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(adminList);
        return pageBean;
    }

}