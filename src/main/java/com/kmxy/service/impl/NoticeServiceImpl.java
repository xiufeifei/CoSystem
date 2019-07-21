package com.kmxy.service.impl;

import com.kmxy.dao.NoticeMapper;
import com.kmxy.entity.Notice;
import com.kmxy.service.NoticeService;
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
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int add(Notice notice) {
        int i = noticeMapper.insertSelective(notice);
        return i;
    }

    @Override
    public Notice selectById(int id) {
        Notice notice = noticeMapper.selectByPrimaryKey(id);
        return notice;
    }

    @Override
    public List<Notice> selectAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public boolean update(Notice notice) {
        return false;
    }

    @Override
    public int delete(Integer id) {
        int i = noticeMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum, Integer pageSize, Notice notice) {
        List<Notice> noticeList = noticeMapper.selectionByCondition(notice);
        int count = noticeMapper.selectCountByCondition(notice);
        PageBean pageBean = new PageBean(pageNum, pageSize, count);
        pageBean.setRecords(noticeList);
        return pageBean;
    }


}