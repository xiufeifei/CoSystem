package com.kmxy.controller.admin;

import com.kmxy.entity.Notice;
import com.kmxy.service.NoticeService;
import com.kmxy.utils.Const;
import com.kmxy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Controller
@RequestMapping("/admin/notice")
public class NoticeController{

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav, Integer pageNum, Integer pageSize, Notice notice){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        PageBean pageBean = noticeService.findbyCondition(pageNum, pageSize, notice);
        pageBean.setUrl("admin/notice/list");
        mav.addObject("data",pageBean);
        mav.setViewName("notice/list");
        return mav;
    }

    @RequestMapping("/noticeTitle")
    public ModelAndView listTitle(ModelAndView mav, Integer pageNum, Integer pageSize, Notice notice) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        PageBean pageBean = noticeService.findbyCondition(pageNum, pageSize, notice);
        pageBean.setUrl("admin/notice/noticeTitle");
        mav.addObject("data", pageBean);
        mav.setViewName("notice/noticeTitle");
        return mav;
    }
    @RequestMapping("/listContentById")
    public ModelAndView listContentById(ModelAndView mav, HttpServletRequest request) {
        int noticeId = Integer.parseInt(request.getParameter("noticeId"));
        Notice notice = noticeService.selectById(noticeId);
        System.out.println(notice);
        mav.addObject("data",notice);
        mav.setViewName("notice/noticeContent");
        return mav;

    }

    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mav, Notice notice){
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mav, Notice notice){
        return mav;
    }

    @RequestMapping("/deleteByNoticeId")
    public void delete(HttpServletRequest request,HttpServletResponse response){
        int noticeId = Integer.parseInt((request.getParameter("noticeId")));
        int notice = noticeService.delete(noticeId);
        if (notice==1){
        try {
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    @RequestMapping("/addArticle")
    public void addArticle(Notice notice, HttpServletRequest request, HttpServletResponse response){
        String title =request.getParameter("title");
        String content =request.getParameter("content");
      /*  String remarks =request.getParameter("remarks");*/
        String origin =request.getParameter("origin");
        String ninfo =request.getParameter("ninfo");

        notice.setTitle(title);
        notice.setContent(content);
       /* notice.setRemarks(remarks);*/
        notice.setOrigin(origin);
        notice.setNinfo(ninfo);

        int add = noticeService.add(notice);
        if(add >0){//成功
            request.setAttribute("url","list");
            try {
                request.getRequestDispatcher("/comm/success.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {//失败
            try {
                request.getRequestDispatcher("/comm/error.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
