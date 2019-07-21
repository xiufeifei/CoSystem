package com.kmxy.service.impl;

import com.kmxy.dao.ReplyMapper;
import com.kmxy.entity.Reply;
import com.kmxy.service.ReplyService;
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
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int add(Reply reply){
        return -1;
    }

    @Override
    public boolean update(Reply reply){
        return false;
    }

    @Override
    public boolean delete(Reply reply){
        return false;
    }

    @Override
    public PageBean findbyCondition(Integer pageNum,Integer pageSize,Reply reply){
        List<Reply> replyList = replyMapper.selectionByCondition(reply);
        int count = replyMapper.selectCountByCondition(reply);
        PageBean pageBean = new PageBean(pageNum,pageSize,count);
        pageBean.setRecords(replyList);
        return pageBean;
    }

}