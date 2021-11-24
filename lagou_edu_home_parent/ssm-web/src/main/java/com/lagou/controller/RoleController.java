package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色列表条件查询
 * */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> allRole = roleService.findAllRole(role);
        ResponseResult result = new ResponseResult(true, 200, "查询所有角色成功", allRole);
        return result;
    }

    /**查询该角色所有的父子菜单信息（分配菜单的第一个接口）*/
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid() {

        // -1 表示查询所有的父子级菜单
        List<Menu> menuList = menuService.findSubMenuByPid(-1);
        // 响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList", menuList);
        ResponseResult responseResult = new ResponseResult(true, 200,
                "查询所有的父子菜单信息成功", map);
        return responseResult;
    }

    /*** 根据角色id查询关联的才当信息ID*/
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(int roleId){
        List<Integer> menuByRoleid = roleService.findMenuByRoleid(roleId);
        ResponseResult result = new ResponseResult(true, 200, "根据角色id查询关联成功", menuByRoleid);
        return result;
    }

    /**为角色分配菜单*/
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.RoleContextMenu(roleMenuVo);
        ResponseResult result = new ResponseResult(true, 200, "为角色分配菜单成功", null);
        return result;
    }

    /**删除角色*/
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(int id){
        roleService.deleteRole(id);
        ResponseResult result = new ResponseResult(true, 200, "删除角色成功", null);
        return result;
    }

}


