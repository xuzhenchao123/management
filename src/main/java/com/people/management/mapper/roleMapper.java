package com.people.management.mapper;

import com.people.management.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface roleMapper {

    /**
     * 新增角色
     * @param role
     * @return
     */
    int insert(Role role);

    /**
     * 更新方法使用
     * @param role
     * @return
     */
    int update(Role role);

    /**
     * 查询下拉框使用 或者列表使用
     * @return
     */
    List<Role> selectAll();

    /**
     * 根据角色id查询角色 更新使用
     * @param  id
     * @return
     */
    Role selectById(@Param("roleid")String id);

}
