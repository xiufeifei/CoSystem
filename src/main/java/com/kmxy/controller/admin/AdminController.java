package com.kmxy.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.kmxy.entity.Admin;
import com.kmxy.service.AdminService;
import com.kmxy.utils.Const;
import com.kmxy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Controller
@RequestMapping("/admin")
public class AdminController{

    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
        public ModelAndView denglu(ModelAndView mav){
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav, Integer pageNum, Integer pageSize, Admin admin){
        if(pageNum == null){
            pageNum=1;
        }
        if (pageSize ==null){
            pageSize= Const.PAGE_SIZE;
        }
        PageBean pageBean = adminService.findbyCondition(pageNum, pageSize, admin);
        pageBean.setUrl("admin/list");
        mav.addObject("data",pageBean);
        mav.setViewName("manager/list");
        return mav;
    }

    @RequestMapping(value = "/denglu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,String> login(Admin admin,String checkCode, HttpServletRequest request){
        HashMap<String ,String> map = new HashMap<>();
        if(admin ==null){
            map.put("type","error");
            map.put("msg","请填写用户信息");
            return map;
        }

        if (StringUtil.isEmpty(checkCode)){
            map.put("type","error");
            map.put("msg","验证码为空");
            return map;
        }

        if (StringUtil.isEmpty(admin.getAccount())){
            map.put("type","error");
            map.put("msg","用户名为空");
            return map;
        }

        if (StringUtil.isEmpty(admin.getPassword())){
            map.put("type","error");
            map.put("msg","密码为空");
            return map;
        }

      /*  校验账号和密码
         查询数据库 */
        Admin admin1 = adminService.selectByAccount(admin.getAccount());
        if (admin1==null){
            map.put("type","error");
            map.put("msg","用户不存在！！！");
            return  map;
        }
        if (!admin.getPassword().equals(admin1.getPassword())){
            map.put("type","error");
            map.put("msg","密码错误！！！");
            return  map;
        }

        Object checkCode1 = request.getSession().getAttribute("checkCode");
        if (checkCode ==null){
            map.put("type","error");
            map.put("msg","回话超时！！1");
            return  map;
        }

        if(!checkCode.equalsIgnoreCase(checkCode1.toString())){
            map.put("type","error");
            map.put("msg","验证码错误");
            return  map;
        }

        request.getSession().setAttribute("admin",admin1);
        map.put("type","success");
        map.put("msg","登录成功");
        return map;
    }

    @RequestMapping("/update")
    public ModelAndView update(ModelAndView mav, Admin admin){
        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView delete(ModelAndView mav, HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mav, Admin admin){
        return mav;
    }
}
