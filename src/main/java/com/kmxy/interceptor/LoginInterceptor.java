package com.kmxy.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
    }
    /**
     * 请求之前进行功能拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("请求路径；"+requestURI);
        Object handle = request.getSession().getAttribute("admin");
        String path = request.getServletContext().getContextPath()+"/admin/denglu";
        System.out.println(path);
        if(handle == null){
            //如果是ajax请求
            String her = request.getHeader("X-Requested-With");
            if("XMLHttpRequest".equals(her)){
                //表示是ajax请求
                Map<String,String> map = new HashMap<String,String>();

                map.put("type", "error");
                map.put("msg", "登录超时或者未登录");
                response.getWriter().write(JSONObject.toJSONString(map));
                return false;
            }
            //未登录或登录超时
            response.sendRedirect(request.getContextPath()+"/admin/login");
            return false;
        }
        return true;
    }
}
