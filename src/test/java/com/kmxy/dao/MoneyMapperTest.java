package com.kmxy.dao;

import com.kmxy.entity.Money;
import com.kmxy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mybatis.xml")
public class MoneyMapperTest {

    @Autowired
    private MoneyMapper moneyMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        Money money = new Money();
        money.setAmount(0.2);
        money.setUserId(2);
        money.setInfo("交全");
            int m = moneyMapper.insertSelective(money);
            System.out.println(m);
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
        Money money = new Money();
        for(int i=2;i<=11;i++){
        money.setAmount(0.2);
        money.setId(i);
        moneyMapper.updateByPrimaryKeySelective(money);

        }
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectionByCondition() {
        Money money = new Money();
        List<Money> monies = moneyMapper.selectionByCondition(money);
        monies.forEach(itme->System.out.println(itme));
    }

    @Test
    public void selectCountByCondition() {
        Money money = new Money();
        int i = moneyMapper.selectCountByCondition(money);
        System.out.println(i);
    }
}