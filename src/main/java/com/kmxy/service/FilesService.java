package com.kmxy.service;

import com.kmxy.entity.Files;
import com.kmxy.utils.PageBean;

import java.io.File;

/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
public interface FilesService {

    int add(Files files);

    int update(Files files);

    boolean delete(Files files);

    PageBean findbyCondition(Integer pageNum, Integer pageSize, Files files);

    int deleteByPrimaryKey(int moneyId);

    Files selectByName(Files file);
    Files selectById(int id);
}
