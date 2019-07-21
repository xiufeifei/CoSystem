package com.kmxy.controller.user;

import com.kmxy.entity.User;
import com.kmxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserServlet {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user, HttpServletResponse response) {
        //设置请求编码
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        //* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*"); /*
        /星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");


        HashMap<String, Object> map = new HashMap<>();
        String password = request.getParameter("password");
        String account = request.getParameter("account");
        System.out.println(account + "******" + password);
        user.setUaccount(account);
        user.setPwd(password);
        User user1 = userService.selectByAccount(user);

        if (user1==null){
            map.put("msg", "用户不存在");
            return map;
        }
        map.put("data", user1);
        map.put("msg", "ok");
        return map;

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> register(HttpServletRequest request, User user, HttpServletResponse response) {
        //设置请求编码
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=utf-8");
        //* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*"); /*
        /星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        Map<String, String> map = new HashMap<>();
        String password = request.getParameter("password");
        String account = request.getParameter("account");
        String username = request.getParameter("username");
        System.out.println(account + "******" + password);

        if(password=="" || password==null){
            map.put("type","fail");
            map.put("msg","密码为空");
            return map;
        }
        if(account=="" || account==null){
            map.put("type","fail");
            map.put("msg","账号为空");
            return map;
        }
        if(username=="" || username==null){
            map.put("type","fail");
            map.put("msg","姓名为空");
            return map;
        }

        user.setUaccount(account);
        user.setPwd(password);
        user.setUsername(username);

        User account1 = userService.selectByAccount(user);
        if (account1 !=null){
            map.put("type","fail");
            map.put("msg", "用户已存在");
            return map;
        }
        int add = userService.add(user);
        if (add < 1) {
            map.put("type","fail");
            map.put("msg", "注册失败");
            return map;
        }
             map.put("type","success");
            map.put("msg", "注册成功");
            return map;
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePassword(HttpServletRequest request, User user, HttpServletResponse response) {
        //设置请求编码
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        //* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*"); /*
        /星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");


        HashMap<String, Object> map = new HashMap<>();
        String password = request.getParameter("password");
        String oldspd = request.getParameter("oldspd");
        String account = request.getParameter("account");
        user.setUaccount(account);
        User user1 = userService.selectByAccount(user);

        if(!user1.getPwd().equals(oldspd)){
            map.put("msg", "输入旧密码错误");
            return map;
        }

        Integer uid = user1.getUid();
        user.setPwd(password);
        user.setUid(uid);
        int i = userService.updateByPrimaryKey(user);
        if(i<1){
            map.put("msg", "修改失败");
            return map;
        }
        map.put("msg", "修改成功，请重新登录");
        return map;

    }
}

