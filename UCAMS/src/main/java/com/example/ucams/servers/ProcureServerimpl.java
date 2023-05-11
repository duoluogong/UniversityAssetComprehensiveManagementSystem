package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ucams.mapper.ProcureMapper;
import com.example.ucams.model.AssetDetails;
import com.example.ucams.model.Procure;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcureServerimpl extends ServiceImpl<ProcureMapper, Procure> implements ProcureServer {

    @Autowired
    private ProcureMapper procureMapper;

    @Override
    public IPage<Procure> getPage(int currentPage, int pageSize, Procure procure) {
        LambdaQueryWrapper<Procure> lqw = new LambdaQueryWrapper<Procure>();
        lqw.eq(procure.getUserId() != null, Procure::getUserId, procure.getUserId());
        lqw.eq(procure.getState() != null&&procure.getState()!=2, Procure::getState, procure.getState());
        lqw.gt(procure.getState() != null&&procure.getState()==2,Procure::getState,1);
        IPage page = new Page(currentPage, pageSize);
        procureMapper.selectPage(page, lqw);
        return page;
    }
}
