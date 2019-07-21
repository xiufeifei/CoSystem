package com.kmxy.controller.admin;

import com.kmxy.entity.Score;
import com.kmxy.entity.User;
import com.kmxy.service.ScoreService;
import com.kmxy.service.UserService;
import com.kmxy.utils.Const;
import com.kmxy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/admin/score")
public class ScoreController{

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav,Integer pageNum,Integer pageSize,Score score,User user,HttpServletRequest request){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }

        if (request.getParameter("username")==" "){
            user.setUsername(null);
            score.setUser(user);
        }

        if (request.getParameter("username")!=null && request.getParameter("username")!=" "){
            String username = request.getParameter("username");
            user.setUsername(username);
           score.setUser(user);
        }
        PageBean pageBean = scoreService.findbyCondition(pageNum, pageSize, score);
        pageBean.setUrl("admin/score/list");
        mav.addObject("data",pageBean);
        mav.setViewName("score/list");
        return mav;
    }

    @RequestMapping("/updateByScoreId")
    public String update(HttpServletRequest request){
        int scoreId = Integer.parseInt(request.getParameter("scoreId"));
        Score score = scoreService.selectById(scoreId);
        request.setAttribute("score",score);
        return "score/update";
    }

    @RequestMapping("/delete")
    public ModelAndView delete(ModelAndView mav,Score score){
        return mav;
    }

    @RequestMapping("/save")
    public void add(HttpServletRequest request,HttpServletResponse response){
        int attendance = Integer.parseInt(request.getParameter("attendance"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        int id = Integer.parseInt(request.getParameter("id"));
        String experience = request.getParameter("experience");
        byte politic = Byte.parseByte(request.getParameter("politic"));

        Score score = new Score();
        score.setId(id);
        score.setExperience(experience);
        score.setAttendance(attendance);
        User user = new User();
        user.setUid(uid);
        user.setPolitic(politic);
        score.setUser(user);

        int i = scoreService.update(score);
        int n = userService.updateByPrimaryKey(user);
        if (i==1){
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
                request.setAttribute("scoreId",id);
                request.getRequestDispatcher("updateByScoreId").forward(request,response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping("/deleteByScoreId")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        int scoreId = Integer.parseInt((request.getParameter("scoreId")));
        scoreService.deleteByPrimaryKey(scoreId);

        try {
            response.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/selectAllUser")
    public ModelAndView selectAllUser(ModelAndView mav){
        List<User> userList = userService.selectAll();
        mav.addObject("data",userList);
        mav.setViewName("score/add");
        return mav;
    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request,Score score,HttpServletResponse response){
        int userId = Integer.parseInt(request.getParameter("userId"));
        int attendance = Integer.parseInt(request.getParameter("attendance"));
        String experience = request.getParameter("experience");

        score.setUserId(userId);
        score.setAttendance(attendance);
        score.setExperience(experience);

        int add = scoreService.add(score);

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
