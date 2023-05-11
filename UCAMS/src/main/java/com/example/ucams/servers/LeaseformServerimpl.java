package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ucams.contraller.R;
import com.example.ucams.mapper.LeaseformMapper;
import com.example.ucams.model.Leaseform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LeaseformServerimpl extends ServiceImpl<LeaseformMapper, Leaseform> implements LeaseformServer {

    @Autowired
    private LeaseformMapper leaseformMapper;

    @Override
    public IPage<Leaseform> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        leaseformMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Leaseform> getPage(int currentPage, int pageSize, Leaseform leaseform) {
        LambdaQueryWrapper<Leaseform> lqw = new LambdaQueryWrapper<>();
        lqw.eq(leaseform.getUserId() != null, Leaseform::getUserId, leaseform.getUserId());
        lqw.eq(leaseform.getState() != null&&leaseform.getState()==1, Leaseform::getState, leaseform.getState());
        lqw.ne(leaseform.getState()==null&&leaseform.getUserId() == null,Leaseform::getState,1);
        lqw.eq(leaseform.getState() != null, Leaseform::getState, leaseform.getState());
        IPage page = new Page(currentPage, pageSize);
        leaseformMapper.selectPage(page, lqw);
        return page;
    }

    @Override
    public R getAll() {
        return new R(true, leaseformMapper.getAll());
    }

    @Override
    public Boolean updatestate(Integer state,Integer id) {
        return leaseformMapper.updatestate(state,id);
    }

    @Override
    public Boolean updateReturnDate(Integer id,Date date) {
        return leaseformMapper.updateReturnDate(id,date);
    }
}
