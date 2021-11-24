package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;
import com.lagou.domain.User_Role_relation;

import java.util.List;

public interface UserService {
    /*** 多条件分页查询* */
    public PageInfo findAllUserByPage(UserVo userVo);

    /*** 用户登录* */
    public User login(User user) throws Exception;

    /**根据id查询用户当前的角色*/
    public List<Role> findUserRelationRoleById(int id);

    /**分配角色*/
    public void userContextRole(UserVo userVo);
}
