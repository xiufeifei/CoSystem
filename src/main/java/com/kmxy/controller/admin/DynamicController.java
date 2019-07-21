package com.kmxy.controller.admin;

import com.kmxy.entity.Dynamic;
import com.kmxy.service.DynamicService;
import com.kmxy.utils.Const;
import com.kmxy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Controller
@RequestMapping("/admin/dynamic")
public class DynamicController{

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav,Integer pageNum,Integer pageSize,Dynamic dynamic){
        if(pageNum==null){
           pageNum=1;
        }
        if(pageSize==null){
            pageSize= Const.PAGE_SIZE;
        }
        PageBean pageBean = dynamicService.findbyCondition(pageNum, pageSize, dynamic);
        pageBean.setUrl("admin/dynamic/list");
        mav.addObject("data",pageBean);
        mav.setViewName("dynimac/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mav,Dynamic dynamic){
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mav,Dynamic dynamic){
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mav,Dynamic dynamic){
        return mav;
    }
}
