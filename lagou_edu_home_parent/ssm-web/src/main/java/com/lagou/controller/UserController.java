package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
* 多条件分页查询
* */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){
        PageInfo allUserByPage = userService.findAllUserByPage(userVo);
        ResponseResult result = new ResponseResult(true, 200, "分页多条件查询成功", allUserByPage);
        return result;
    }

    /**用户登录*/
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User user2 = userService.login(user);
        if(user2 != null){
            //获取到session
            HttpSession session = request.getSession();
            //向session中存user.id
            session.setAttribute("user_id",user2.getId());
            //生成一个随机数作为令牌的值
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token",access_token);
            //把数据传给前端
            Map<String, Object> map = new HashMap<>();
            map.put("user_id",user2.getId());
            map.put("access_token",access_token);
            return new ResponseResult(true,200,"登录成功",map);
        }
        else{
            return new ResponseResult(true,400,"用户名或密码错误",null);
        }


    }

    /**获取用户拥有的菜单权限(回显)*/
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(int id){
        List<Role> roleList = userService.findUserRelationRoleById(id);
        return new ResponseResult(true,200,"分配角色回显成功",roleList);
    }

    /**分配角色*/
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);
        return new ResponseResult(true,200,"分配角色成功",null);
    }



}
