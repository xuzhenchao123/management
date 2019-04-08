package com.people.management.controller;

import com.people.management.entity.User;
import com.people.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/user"})
public class LoginController {

    /**
     * 最开始希望用Map的形式接参数，后来不用了，将请求对应的接受方式记录一下
     *
     * @RequestBody Map<String,Object> map      post请求
     * @RequestParam Map<String,Object> map     get请求
     */

    /**
     * 注入service
     */
    @Autowired
    private UserService userService;


    /**
     * 同时这个时候可以自己了解一下@Controller与@RestController的区别，以及@ResponseBody的用法。
     */

    /**
     * 跳转到用户登录页面
     * @return 登录页面
     */
    @RequestMapping(value = {"/loginHtml"})
    public String loginHtml(){
        return "userLogin";
    }

    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping(value = {"/registerpage"})
    public String registerpage(){
        return "/user/register";
    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    //@ResponseBody
    @RequestMapping(value = {"/userLogin"})
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request){

        if(StringUtils.isEmpty(username)){
            return "用户名不能为空";
        }

        if(StringUtils.isEmpty(password)){
            return "密码不能为空";
        }

        User user = userService.userlogin(username,password);

        if(user != null){                                                  //登录成功
            request.getSession().setAttribute("session_user",user);     //将用户信息放入session  用于后续的拦截器
            return "redirect:/user/queryAllUser";
        }
        return "loginError";
    }

    /**
     * 注册新用户
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("age") int age){

        if(StringUtils.isEmpty(username)){
            return "用户名不能为空";
        }

        if(StringUtils.isEmpty(password)){
            return "密码不能为空";
        }

        if(StringUtils.isEmpty(password2)){
            return "确认密码不能为空";
        }

        if(!password.equals(password2)){
            return "两次密码不相同，注册失败！！";
        }else {
            int res = userService.adduser(username,password,age);
            if(res == 0){
                return "注册失败！";
            }else {
                return "注册成功！";
            }
        }

    }

//    /**
//     * 用于测试拦截器（用户是否登录，查看session）
//     * 查询用户列表  http://localhost:8080/user/queryAllUser
//     * @return 用户列表（json串）
//     */
//    @ResponseBody
//    @RequestMapping(value = {"/queryAllUser"})
//    public List<Map<String,Object>> queryAllUser(){
//
//        return userService.queryAllUser();
//    }
    @RequestMapping(value = {"/queryAllUser"})
    public String queryAllUser(Model model){
        List<Map<String,Object>> listMap= userService.queryAllUser();
        model.addAttribute("list", listMap);
        return  "/user/list";
    }

    @RequestMapping(value = {"/delUserid"})
    public String delUserid(String id){
        int res = userService.deluser(id);
        if(res == 0){
            return "删除失败！";
        }else {
//            return "删除成功！";
            return "redirect:/user/queryAllUser";
        }
//        return  "删除信息是："+id;
    }
    @ResponseBody
    @RequestMapping(value = {"/updateUser"})
    public User updateUser(String id){
       User user=userService.selectByid(id);
        return  user;
    }
}
