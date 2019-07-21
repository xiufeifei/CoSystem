package com.kmxy.utils;


import javax.servlet.ServletContext;

public class pathUtil {


    public static String getPath(ServletContext servletContext) {
        String pathRoot = servletContext.getRealPath("/static/document");
        System.out.println("root:" + pathRoot);
        String replace = pathRoot.replace("\\t", "*");
        System.out.println("replace:" + replace);
        String substringPath = replace.substring(0, replace.indexOf("*"));
        System.out.println("new:" + substringPath);
        return substringPath;
    }
}
