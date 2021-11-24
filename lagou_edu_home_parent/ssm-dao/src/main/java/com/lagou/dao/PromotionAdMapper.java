package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    /**
        分页获取所有的广告列表
    */
    public List<PromotionAd> findAllAdByPage();

    /**
     * 新增广告(未完)
     * */
    public void savePromotionAd(PromotionAd promotionAd);

    /**
     * 更新广告(未完)
     * */
    public void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 回显广告
     */

    /**
     * 状态上下线修改
     */
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
