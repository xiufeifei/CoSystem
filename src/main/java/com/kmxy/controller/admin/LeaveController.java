package com.kmxy.controller.admin;

import com.kmxy.entity.Leave;
import com.kmxy.service.LeaveService;
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
@RequestMapping("/admin/leave")
public class LeaveController{

    @Autowired
    private LeaveService leaveService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav,Integer pageNum,Integer pageSize,Leave leave){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        PageBean pageBean = leaveService.findbyCondition(pageNum, pageSize, leave);
        pageBean.setUrl("admin/leave/list");
        mav.addObject("data",pageBean);
        mav.setViewName("leave/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mav,Leave leave){
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mav,Leave leave){
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mav,Leave leave){
        return mav;
    }
}
