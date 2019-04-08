package com.people.management.service;

import com.people.management.entity.Role;
import com.people.management.mapper.roleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {


    @Autowired
    public roleMapper rolemapper;

    /**
     * 新增角色
     * @param role
     * @return
     */
    public int insert(Role role){

        return rolemapper.insert(role);
    }

    /**
     * 更新方法使用
     * @param role
     * @return
     */
    public int update(Role role){
        return rolemapper.update(role);
    }

    /**
     * 查询下拉框使用 或者列表使用
     * @return
     */
    public List<Role> selectAll(){
        return rolemapper.selectAll();
    }

    /**
     * 根据角色id查询角色 更新使用
     * @param  id
     * @return
     */
    public Role selectById(String id){
        return rolemapper.selectById(id);
    }

}
