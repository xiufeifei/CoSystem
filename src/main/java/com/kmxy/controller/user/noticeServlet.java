package com.kmxy.controller.user;

import com.kmxy.entity.Notice;
import com.kmxy.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user/notice")
public class noticeServlet {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> weiSelect(){
        List<Notice> noticeList = noticeService.selectAll();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",noticeList);
        return map;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Map<String,Object> selectById(HttpServletRequest request){
        int i = Integer.parseInt(request.getParameter("id"));
        Notice notice = noticeService.selectById(i);
        Map<String, Object> map = new HashMap<>();
        if (notice==null){
            map.put("msg","查找失败");
        }
        map.put("msg","查找成功");
        map.put("data",notice);
        return map;
    }
}
