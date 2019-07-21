package com.kmxy.listener;

import com.kmxy.entity.Admin;
import com.kmxy.entity.User;
import com.kmxy.service.AdminService;
import com.kmxy.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;


public class UserServletListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {


    }


    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext app = arg0.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(app);
        UserService bean = context.getBean(UserService.class);
        List<User> users = bean.selectAll();
        app.setAttribute("userList",users);

    }
}
