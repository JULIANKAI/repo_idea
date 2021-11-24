package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;

import java.util.List;


public interface RoleService {

    /*** 角色列表条件查询* */
    public List<Role> findAllRole(Role role);

    /*** 根据角色id查询关联的才当信息ID*/
    public List<Integer> findMenuByRoleid(int Roleid);

    /**根据角色的id清空中间表的关联关系*/
    /**重新建立中间表的关联关系*/
    public void RoleContextMenu(RoleMenuVo roleMenuVo);

    /**根据角色id删除角色*/
    public void deleteRole(int roleId);
}
