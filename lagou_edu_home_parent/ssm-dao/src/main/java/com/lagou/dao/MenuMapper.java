package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;


public interface MenuMapper {
    /*** 查询父子级菜单*/
    public List<Menu> findSubMenuByPid(int id);

    /**查询所有菜单*/
    public List<Menu> findAllMenu();
}
