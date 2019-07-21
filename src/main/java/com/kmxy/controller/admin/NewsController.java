package com.kmxy.controller.admin;

import com.kmxy.entity.News;
import com.kmxy.service.NewsService;
import com.kmxy.utils.Const;
import com.kmxy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Controller
@RequestMapping("/admin/news")
public class NewsController {

    @Autowired
    private NewsService newsService;




    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav, Integer pageNum, Integer pageSize, News news) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        PageBean pageBean = newsService.findbyCondition(pageNum, pageSize, news);
        pageBean.setUrl("admin/news/list");
        mav.addObject("data", pageBean);
        mav.setViewName("news/list");
        return mav;
    }

    @RequestMapping("/listTitle")
    public ModelAndView listTitle(ModelAndView mav, Integer pageNum, Integer pageSize, News news) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        PageBean pageBean = newsService.findbyCondition(pageNum, pageSize, news);
        pageBean.setUrl("admin/news/newTitle");
        mav.addObject("data", pageBean);
        mav.setViewName("news/newTitle");
        return mav;
    }
    @RequestMapping("/listContentById")
    public ModelAndView listContentById(ModelAndView mav,HttpServletRequest request) {
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        News news = newsService.selectById(newsId);
        System.out.println(news);
        mav.addObject("data",news);
        mav.setViewName("news/newContent");
        return mav;

    }
    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mav, News news) {
        return mav;
    }

    @RequestMapping("/deleteById")
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        int newsId = Integer.parseInt((request.getParameter("newsId")));
        newsService.delete(newsId);

        try {
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addArticle")
    public void addArticle(News news, HttpServletRequest request, HttpServletResponse response){
        String title =request.getParameter("title");
        String content =request.getParameter("content");
        String origin =request.getParameter("origin");
        String info =request.getParameter("info");
        news.setTitle(title);
        news.setContent(content);
        news.setOrigin(origin);
        news.setInfo(info);

        System.out.println(news);

        int add = newsService.add(news);
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


