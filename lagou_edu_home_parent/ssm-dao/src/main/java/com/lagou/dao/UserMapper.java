package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;
import com.lagou.domain.User_Role_relation;

import java.util.List;


public interface UserMapper {
    /*** 多条件分页查询* */
    public List<User> findAllUserByPage(UserVo uservo);

    /*** 用户登录* */
    public User login(User user);

    /**根据id查询用户当前的角色*/
    public List<Role> findUserRelationRoleById(int id);

    /**分配角色之前先删除关系表的关联关系*/
    public void deleteUserContextRole(Integer userId);

    /**分配角色*/
    public void userContextRole(User_Role_relation user_role_relation);

}
