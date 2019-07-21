package com.kmxy.controller.admin;

import com.kmxy.entity.Money;
import com.kmxy.service.MoneyService;
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
@RequestMapping("/admin/money")
public class MoneyController{

    @Autowired
    private MoneyService moneyService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav,Integer pageNum,Integer pageSize,Money money){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        PageBean pageBean = moneyService.findbyCondition(pageNum, pageSize, money);
        pageBean.setUrl("admin/money/list");
        mav.addObject("data",pageBean);
        mav.setViewName("money/list");
        return mav;
    }

    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mav,Money money){
        return mav;
    }

    @RequestMapping("/deleteByPrimaryKey")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        int moneyId = Integer.parseInt(request.getParameter("moneyId"));
        moneyService.deleteByPrimaryKey(moneyId);
        try {
            response.sendRedirect("admin/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request,HttpServletResponse response){
        Money money = new Money();
        if (request.getParameter("userId") != null && request.getParameter("userId") != "") {
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            money.setUserId(userId);
        }

        double amount = Double.parseDouble(request.getParameter("amount"));
        String info = request.getParameter("info");
        money.setAmount(amount);
        money.setInfo(info);

        int add = moneyService.add(money);
        if (add > 0) {//成功
            request.setAttribute("url", "list");
            try {
                request.getRequestDispatcher("/comm/success.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {//失败
            try {
                request.getRequestDispatcher("/comm/error.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
