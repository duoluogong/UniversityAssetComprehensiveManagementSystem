package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ucams.model.AssetDetails;
import com.example.ucams.model.Procure;

public interface ProcureServer extends IService<Procure> {
    IPage<Procure> getPage(int currentPage, int pageSize, Procure procure);
}
