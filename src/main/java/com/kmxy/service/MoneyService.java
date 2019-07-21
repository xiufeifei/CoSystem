package com.kmxy.service;

import com.kmxy.entity.Money;
import com.kmxy.utils.PageBean;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface MoneyService {

    int add(Money money);

    int update(Money money);

    boolean delete(Money money);

    int deleteByPrimaryKey(Integer id);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Money money);

}
