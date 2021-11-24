package com.lagou.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    /*分页查询*/
    @Override
    public PageInfo<PromotionAd> findAllAdByPage(PromotionAdVo promotionAdVo) {
        //使用pagehelper插件分页查询
        PageHelper.startPage(promotionAdVo.getCurrentPage(),promotionAdVo.getPageSize());
        //调用mapper
        List<PromotionAd> allAdByPage = promotionAdMapper.findAllAdByPage();
        //使用pageinfo获取配置信息，
        PageInfo<PromotionAd> info = new PageInfo<>(allAdByPage);
        return info;
    }

    /*添加广告*/
    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    /*更新广告*/
    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    /*回显广告*/

    /*广告状态上下线修改*/
    @Override
    public void updatePromotionAdStatus(int id, int status) {
        //封装数据
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());

        //调用mapper
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
