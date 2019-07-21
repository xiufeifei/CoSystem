package com.kmxy.controller.user;

import com.kmxy.entity.Score;
import com.kmxy.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/score")
public class scoreServlet {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/listById")
    @ResponseBody
    public Map<String,Object> score(HttpServletRequest request, HttpServletResponse response){
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
        Score score = scoreService.selectByUserId();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",score);
        return map;
    }
}
