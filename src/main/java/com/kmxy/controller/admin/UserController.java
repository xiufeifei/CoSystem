package com.kmxy.controller.admin;

import com.kmxy.entity.User;
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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * @author HC
 * @version 0.1
 * Created on 2019-04-14
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mav, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        User user = new User();
        if (request.getParameter("politic") != null && request.getParameter("politic") != "") {
            byte politic = Byte.parseByte(request.getParameter("politic"));
            user.setPolitic(politic);
            request.setAttribute("politic", politic);
        }

        if (request.getParameter("username") != null && request.getParameter("username") != " "
                && request.getParameter("username") != "") {
            String username = request.getParameter("username");
            user.setUsername(username);
        }
        if (request.getParameter("player") != null && request.getParameter("player") != "") {
            byte player = Byte.parseByte(request.getParameter("player"));
            user.setPlayer(player);
            request.setAttribute("player", player);
        }
        System.out.println("****" + user.getUsername());
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = Const.PAGE_SIZE;
        }
        user.setPageNum(pageNum);
        user.setPageSize(pageSize);
        PageBean pageBean = userService.findbyCondition(pageNum, pageSize, user);
        System.out.println(pageBean);
        pageBean.setUrl("admin/user/list");
        mav.addObject("data", pageBean);
        mav.setViewName("user/List");
        return mav;
    }

    @RequestMapping("/updateByUserId")
    public String updateByUserId(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userService.selectById(userId);
        request.setAttribute("user", user);
        return "user/update";
    }

    @RequestMapping("/deleteByUserId")
    public void delete(HttpServletRequest request, HttpServletResponse response,User user) {
        int userId = Integer.parseInt((request.getParameter("userId")));
        user.setUid(userId);
        user.setState((byte) 4);
        int i = userService.updateByPrimaryKey(user);

        if (i == 1) {
            request.setAttribute("url", "list");
            try {
                request.getRequestDispatcher("/comm/success.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {//失败
            try {
                request.getRequestDispatcher("/comm/error.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        int uid = Integer.parseInt(request.getParameter("uid"));
        User user = new User();
        if (request.getParameter("adminId") != null && request.getParameter("adminId") != "") {
            Integer adminId = Integer.parseInt(request.getParameter("adminId"));
            user.setAdminId(adminId);
        }
        String password=request.getParameter("password");
        byte politic = Byte.parseByte(request.getParameter("politic"));
        String username = request.getParameter("username");
        String account = request.getParameter("account");
        byte player = Byte.parseByte(request.getParameter("player"));
        byte state = Byte.parseByte(request.getParameter("state"));
        String tell = request.getParameter("tell");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String email = request.getParameter("email");
        String branch = request.getParameter("branch");
        String education = request.getParameter("education");
        String faculty = request.getParameter("faculty");
        String junior = request.getParameter("junior");
        String grades = request.getParameter("grades");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String info = request.getParameter("beizhu");

        user.setFaculty(faculty);
        user.setJunior(junior);
        user.setPwd(password);
        user.setUaccount(account);
        user.setGrades(grades);
        user.setTell(tell);
        user.setUinfo(info);
        user.setEducation(education);
        user.setBranch(branch);
        user.setBirthday(birthday);
        user.setUsername(username);
        user.setPolitic(politic);
        user.setState(state);
        user.setPlayer(player);
        user.setUgender(gender);
        user.setUinfo(info);
        user.setEmail(email);
        user.setUid(uid);
        int i = userService.updateByPrimaryKey(user);
        if (i == 1) {
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
                request.setAttribute("userId", uid);
                request.getRequestDispatcher("updateByUserId").forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/add")
    public void addUser(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        if (request.getParameter("adminId") != null && request.getParameter("adminId") != "") {
            Integer adminId = Integer.parseInt(request.getParameter("adminId"));
            user.setAdminId(adminId);
        }
        String password=request.getParameter("password");
        byte politic = Byte.parseByte(request.getParameter("politic"));
        String username = request.getParameter("username");
        String account = request.getParameter("account");
        byte player = Byte.parseByte(request.getParameter("player"));
        byte state = Byte.parseByte(request.getParameter("state"));
        String tell = request.getParameter("tell");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String email = request.getParameter("email");
        String branch = request.getParameter("branch");
        String education = request.getParameter("education");
        String faculty = request.getParameter("faculty");
        String junior = request.getParameter("junior");
        String grades = request.getParameter("grades");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

        String info = request.getParameter("beizhu");

        user.setFaculty(faculty);
        user.setJunior(junior);
        user.setPwd(password);
        user.setUaccount(account);
        user.setGrades(grades);
        user.setTell(tell);
        user.setUinfo(info);
        user.setEducation(education);
        user.setBranch(branch);
        user.setBirthday(birthday);
        user.setUsername(username);
        user.setPolitic(politic);
        user.setState(state);
        user.setPlayer(player);
        user.setUgender(gender);
        user.setUinfo(info);
        user.setEmail(email);
        int add = userService.add(user);
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

    @RequestMapping("/selectByAccount")
    @ResponseBody()
    public Map<String,Object> userIsExits(HttpServletRequest request,User user){
        HashMap<String, Object> map = new HashMap<>();
        String account = request.getParameter("account");
        user.setUaccount(account);
        User user1 = userService.selectByAccount(user);
        if(user1!=null){
            map.put("msg",true);
            return map;
        }

        map.put("msg",false);
        return map;
    }
}
