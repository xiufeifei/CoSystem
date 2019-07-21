package com.kmxy.listener;

import com.kmxy.entity.Admin;
import com.kmxy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;


public class AdminServletListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {


    }


    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext app = arg0.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(app);
        AdminService bean = context.getBean(AdminService.class);
        List<Admin> admins = bean.selectAll();
        app.setAttribute("adminList",admins);

    }
}
