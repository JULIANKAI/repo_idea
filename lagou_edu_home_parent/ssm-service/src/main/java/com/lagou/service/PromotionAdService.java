package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

import java.util.List;

public interface PromotionAdService {
    /*分页查询*/
    public PageInfo<PromotionAd> findAllAdByPage(PromotionAdVo promotionAdVo);

    /*添加广告*/
    public void savePromotionAd(PromotionAd promotionAd);

    /*更新广告*/
    public void updatePromotionAd(PromotionAd promotionAd);

    /*回显广告*/


    /*广告状态上下线修改*/
    public void updatePromotionAdStatus(int id,int status);
}
