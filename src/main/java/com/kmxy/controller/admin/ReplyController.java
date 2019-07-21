package com.kmxy.controller.admin;

import com.kmxy.entity.Reply;
import com.kmxy.service.ReplyService;
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
@RequestMapping("/admin/reply")
public class ReplyController{

    @Autowired
    private ReplyService replyService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav,Integer pageNum, Integer pageSize,Reply reply){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        PageBean pageBean = replyService.findbyCondition(pageNum, pageSize, reply);
        pageBean.setUrl("admin/reply/list");
        mav.addObject("data",pageBean);
        mav.setViewName("reply/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mav,Reply reply){
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mav,Reply reply){
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mav,Reply reply){
        return mav;
    }
}
