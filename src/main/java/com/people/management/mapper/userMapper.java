package com.people.management.mapper;

import com.people.management.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface userMapper {
    //用户登录
    User userlogin(@Param("username") String username, @Param("password") String password);
    /**
     * 在这里写了两种新建用户的方式(具体查看sql语句)：
     *     利用UUID()生成id，在存入用户
     *  则将将id的类型改为varchar型，同时取消自增。
     * 无论再用那种方式，都需要注意实体类中的类型是否与数据库一致，若不一致，项目运行时报错。
     */

    //注册新用户(方式1)
    int adduser(@Param("username") String username, @Param("password") String password, @Param("age") int age);

    //查询用户列表
    List<Map<String,Object>> queryAllUser();

    int deluser(@Param("userid") String userid);

    User selectByid(@Param("userid") String userid);
    
}
