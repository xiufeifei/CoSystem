package com.kmxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = {"/admin/{path}"})
    public String index(@PathVariable String path) {
        System.out.println(path);
        return path;
    }
    @RequestMapping(value = {"/admin/{path}/{aim}"})
    public String index(@PathVariable String path, @PathVariable String aim) {
        System.out.println(path + " " + aim);
        return path + "/" + aim;
    }

}

