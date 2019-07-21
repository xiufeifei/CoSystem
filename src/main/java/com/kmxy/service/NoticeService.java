package com.kmxy.service;

import com.kmxy.entity.Notice;
import com.kmxy.utils.PageBean;

import java.util.List;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface NoticeService {

    int add(Notice notice);

    Notice selectById(int id);


    List<Notice> selectAll();


    boolean update(Notice notice);

    int delete(Integer id);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Notice notice);

}
