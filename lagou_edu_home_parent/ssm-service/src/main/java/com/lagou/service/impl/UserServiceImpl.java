package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;
import com.lagou.domain.User_Role_relation;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 多条件分页查询
 * */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        //在查询前使用
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> allUserByPage = userMapper.findAllUserByPage(userVo);
        //查询到的数据封装到userPageInfo里面
        PageInfo<User> userPageInfo = new PageInfo<>(allUserByPage);
        return userPageInfo;
    }

    /**用户登录*/
    @Override
    public User login(User user) throws Exception {
        User user1 = userMapper.login(user);
        //判断该用户是否存在并且用户的密码是否一致
        if(user1 != null && Md5.verify(user.getPassword(),"lagou",user1.getPassword())){
            return user1;
        }
        else {
            return null;
        }

    }

    /**根据id查询用户当前的角色*/
    @Override
    public List<Role> findUserRelationRoleById(int id) {
        List<Role> userRelationRoleById = userMapper.findUserRelationRoleById(id);
        return userRelationRoleById;
    }

    /**分配角色*/
    @Override
    public void userContextRole(UserVo userVo) {
        /**分配角色之前先删除关系表的关联关系*/
        userMapper.deleteUserContextRole(userVo.getUserId());
        for (Integer roleid : userVo.getRoleIdList()) {
            //封装
            User_Role_relation url = new User_Role_relation();
            url.setUserId(userVo.getUserId());
            url.setRoleId(roleid);

            Date date = new Date();
            url.setCreatedTime(date);
            url.setUpdatedTime(date);

            url.setCreatedBy("system");
            url.setUpdatedby("system");

            /**分配角色*/
            userMapper.userContextRole(url);
        }

    }
}
