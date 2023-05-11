package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ucams.mapper.AssetDetailsMapper;
import com.example.ucams.model.AssetDetails;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AssetDetailsServerimpl extends ServiceImpl<AssetDetailsMapper, AssetDetails> implements AssetDetailsServer {
    @Autowired
    private AssetDetailsMapper assetDetailsMapper;

    @Override
    public IPage<AssetDetails> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        assetDetailsMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<AssetDetails> getPage(int currentPage, int pageSize, AssetDetails asset) {
        LambdaQueryWrapper<AssetDetails> lqw = new LambdaQueryWrapper<AssetDetails>();
        lqw.like(asset.getAssetId() != null, AssetDetails::getAssetId, asset.getAssetId());
        lqw.like(Strings.isNotEmpty(asset.getAssetName()), AssetDetails::getAssetName, asset.getAssetName());
        lqw.like(Strings.isNotEmpty(asset.getCategoryId()), AssetDetails::getCategoryId, asset.getCategoryId());
        lqw.like(Strings.isNotEmpty(asset.getAcademyId()), AssetDetails::getAcademyId, asset.getAcademyId());
        lqw.like(asset.getState() != null, AssetDetails::getState, asset.getState());
        IPage page = new Page(currentPage, pageSize);
        assetDetailsMapper.selectPage(page, lqw);
        return page;
    }

    @Override
    public Boolean updateForlease(Integer surplus, Integer aid) {
        return assetDetailsMapper.updateForlease(surplus, aid);
    }

}
