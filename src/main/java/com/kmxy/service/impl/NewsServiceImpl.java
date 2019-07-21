package com.kmxy.service.impl;

import com.kmxy.dao.NewsMapper;
import com.kmxy.entity.News;
import com.kmxy.service.NewsService;
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
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public int add(News news){
        int i = newsMapper.insertSelective(news);
        return i;
    }

    @Override
    public News selectById(int id) {
        News i = newsMapper.selectByPrimaryKey(id);
        return i;
    }

    @Override
    public List<News> selectAll() {
        return newsMapper.selectionAll();
    }

    @Override
    public boolean update(News news){
        int i = newsMapper.updateByPrimaryKeySelective(news);
        return true;

    }

    @Override
    public int delete(Integer id){
        int i = newsMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum, Integer pageSize, News news){
        List<News> newsList = newsMapper.selectionByCondition(news);
        int count = newsMapper.selectCountByCondition(news);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(newsList);
        return pageBean;
    }

}