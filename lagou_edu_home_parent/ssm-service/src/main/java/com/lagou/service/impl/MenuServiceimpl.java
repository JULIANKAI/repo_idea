package com.lagou.service.impl;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询父子级菜单*/
@Service
public class MenuServiceimpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /*** 查询父子级菜单*/
    @Override
    public List<Menu> findSubMenuByPid(int id) {
        List<Menu> subMenuByPid = menuMapper.findSubMenuByPid(id);
        return subMenuByPid;
    }

    /**查询所有菜单*/
    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }
}
