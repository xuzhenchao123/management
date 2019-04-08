package com.people.management.controller;

import com.people.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String hello(){
//        return "管理项目开始1222";
//    }
//
    @Autowired
   public UserService userService;

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }


    @RequestMapping(value = "/test")
    public ModelAndView  test(ModelAndView mv){
     //   int res = userService.addUser("网三","123456",20);
        int res =userService.adduser("网三","123456",20);
//        List<Map<String,Object>> userlist=userService.queryAllUser();
//        System.out.println("======================="+userlist.size());
        System.out.println("======================="+res);
         mv.setViewName("/test");
         mv.addObject("title","欢迎使用ModelAndView");
         return mv;
    }
}
