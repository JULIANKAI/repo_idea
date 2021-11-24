package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**查询资源分类信息列表*/
public interface ResourceCategoryService {
    public List<ResourceCategory> findAllResourceCategory();
}
