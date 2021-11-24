package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;


public interface RoleMapper {

    /*** 角色列表条件查询* */
    public List<Role> findAllRole(Role role);

    /*** 根据角色id查询关联的才当信息ID*/
    public List<Integer> findMenuByRoleid(int Roleid);

    /**根据角色的id清空中间表的关联关系*/
    public void deleteRoleContextMenu(int roleId);

    /**重新建立中间表的关联关系*/
    public void RoleContextMenu(Role_menu_relation role_menu_relation);

    /**根据角色id删除角色*/
    public void deleteRole(int roleId);


}


