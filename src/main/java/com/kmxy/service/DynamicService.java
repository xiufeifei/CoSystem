package com.kmxy.service;

import com.kmxy.entity.Dynamic;
import com.kmxy.utils.PageBean;

import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface DynamicService {

    int add(Dynamic dynamic);

    Dynamic selectById(int id);


    List<Dynamic> selectAll();

    boolean update(Dynamic dynamic);

    boolean delete(Dynamic dynamic);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Dynamic dynamic);

}
