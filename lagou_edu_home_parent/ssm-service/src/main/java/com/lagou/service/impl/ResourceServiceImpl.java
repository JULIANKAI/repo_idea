package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    /**资源信息分页&条件查询*/
    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {

        /**分页插件*/
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());

        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);

        /**分页查询到的数据封装到pageInfo*/
        PageInfo<Resource> pageInfo = new PageInfo<>(allResource);

        return pageInfo;
    }
}
