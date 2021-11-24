package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

/**资源信息分页&条件查询*/
public interface ResourceService {
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo);
}
