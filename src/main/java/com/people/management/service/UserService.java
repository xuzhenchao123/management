package com.people.management.service;

import com.people.management.entity.User;
import com.people.management.mapper.userMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {


    @Autowired
    public userMapper usermapper;
    //用户登录
   public User userlogin(String username,String password){
       return usermapper.userlogin(username,password);
   }
    /**
     * 在这里写了两种新建用户的方式(具体查看sql语句)：
     *     利用UUID()生成id，在存入用户
     *  则将将id的类型改为varchar型，同时取消自增。
     * 无论再用那种方式，都需要注意实体类中的类型是否与数据库一致，若不一致，项目运行时报错。
     */

    //注册新用户(方式1)
    public int adduser(String username,  String password,int age){
        return  usermapper.adduser(username,password,age);
    }

    //查询用户列表
    public List<Map<String,Object>> queryAllUser(){
        return    usermapper.queryAllUser();
    }
    public int deluser(String id){
        return  usermapper.deluser(id);
    }

    //注册新用户(方式1)
    public User selectByid(String id){
        return  usermapper.selectByid(id);
    }

}
