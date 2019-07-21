package com.kmxy.service;

import com.kmxy.entity.Leave;
import com.kmxy.utils.PageBean;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface LeaveService {

    int add(Leave leave);

    boolean update(Leave leave);

    boolean delete(Leave leave);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Leave leave);

}
