package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ucams.model.AssetDetails;

import java.util.Date;

public interface AssetDetailsServer extends IService<AssetDetails> {
    IPage<AssetDetails> getPage(int currentPage, int pageSize);

    IPage<AssetDetails> getPage(int currentPage, int pageSize, AssetDetails asset);

    Boolean updateForlease(Integer surplus, Integer aid);
}
