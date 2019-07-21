package com.kmxy.service;

import com.kmxy.entity.News;
import com.kmxy.utils.PageBean;

import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface NewsService {

    int add(News news);

    News selectById(int id);


    List<News> selectAll();

    boolean update(News news);

    int delete(Integer id);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, News news);

}
