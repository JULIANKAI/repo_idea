package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 角色列表条件查询
 * */
@Service
public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    /*** 根据角色id查询关联的才当信息ID*/
    @Override
    public List<Integer> findMenuByRoleid(int roleid) {
        List<Integer> menuByRoleid = roleMapper.findMenuByRoleid(roleid);
        return menuByRoleid;
    }

    /**根据角色的id清空中间表的关联关系*/
    /**重新建立中间表的关联关系*/
    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {
        /**根据角色的id清空中间表的关联关系*/
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        /**重新建立中间表的关联关系*/
        for (Integer mid : roleMenuVo.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());

            //封装数据
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.RoleContextMenu(role_menu_relation);
        }

    }

    /**根据角色id删除角色*/
    @Override
    public void deleteRole(int roleId) {
        /**删除角色时候，若该角色有关联关系表，则需要先删除关联关系表中的数据*/
        roleMapper.deleteRoleContextMenu(roleId);
        /**删除角色*/
        roleMapper.deleteRole(roleId);

    }
}
