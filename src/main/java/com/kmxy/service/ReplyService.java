package com.kmxy.service;

import com.kmxy.entity.Reply;
import com.kmxy.utils.PageBean;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface ReplyService {

    int add(Reply reply);

    boolean update(Reply reply);

    boolean delete(Reply reply);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Reply reply);

}
