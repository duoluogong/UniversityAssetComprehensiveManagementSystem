package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ucams.contraller.R;
import com.example.ucams.model.AssetDetails;
import com.example.ucams.model.Leaseform;

import java.util.Date;

public interface LeaseformServer extends IService<Leaseform> {
    IPage<Leaseform> getPage(int currentPage, int pageSize);

    IPage<Leaseform> getPage(int currentPage, int pageSize, Leaseform leaseform);

    R getAll();

    Boolean updatestate(Integer state,Integer id);

    Boolean updateReturnDate(Integer id,Date date);
}
