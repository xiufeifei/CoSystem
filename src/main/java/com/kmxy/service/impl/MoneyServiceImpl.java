package com.kmxy.service.impl;

import com.kmxy.dao.MoneyMapper;
import com.kmxy.entity.Money;
import com.kmxy.service.MoneyService;
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
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyMapper moneyMapper;

    @Override
    public int add(Money money){
        return moneyMapper.insertSelective(money);
    }

    @Override
    public int update(Money money){
        return 0;
    }

    @Override
    public boolean delete(Money money){
        return false;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int i = moneyMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum,Integer pageSize,Money money){
        List<Money> moneyList = moneyMapper.selectionByCondition(money);
        int count = moneyMapper.selectCountByCondition(money);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(moneyList);
        return pageBean;
    }

}