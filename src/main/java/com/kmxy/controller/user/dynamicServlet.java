package com.kmxy.controller.user;

import com.kmxy.entity.Dynamic;
import com.kmxy.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user/dynamic")
public class dynamicServlet {

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> weiSelect(){
        List<Dynamic> dynamicList = dynamicService.selectAll();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",dynamicList);
        return map;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Map<String,Object> selectById(HttpServletRequest request){
        int i = Integer.parseInt(request.getParameter("id"));
        Dynamic dynamic = dynamicService.selectById(i);
        Map<String, Object> map = new HashMap<>();
        if (dynamic==null){
            map.put("msg","查找失败");
        }
        map.put("msg","查找成功");
        map.put("data",dynamic);
        return map;
    }
}
