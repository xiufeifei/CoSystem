package com.kmxy.service;

import com.kmxy.entity.Admin;
import com.kmxy.utils.PageBean;

import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface AdminService {

    int add(Admin admin);

    boolean update(Admin admin);

    boolean delete(Admin admin);

    Admin selectBy(Integer id);
    List<Admin> selectAll();

    Admin selectByAccount(String account);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Admin admin);

}
