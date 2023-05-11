package com.example.ucams.contraller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ucams.model.AssetDetails;
import com.example.ucams.model.Leaseform;
import com.example.ucams.servers.LeaseformServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/Leaseform")
public class LeaseformContraller {
    @Autowired
    private LeaseformServer leaseformServer;

    @PostMapping
    public R save(@RequestBody Leaseform leaseform) {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        leaseform.setLeaseDate(date1);
        return new R(true, leaseformServer.save(leaseform));
    }

//    根据ID的查询
@GetMapping("/{id}")
public R getById(@PathVariable Integer id) {
    return new R(true, leaseformServer.getById(id));
}

    //    删除单个
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return new R(true, leaseformServer.removeById(id));
    }

    //分页
    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Leaseform leaseform) {
        IPage<Leaseform> page = leaseformServer.getPage(currentPage, pageSize, leaseform);
        //为了防止删除末页最后一个数据时页面出现的的无数据显示
        if (currentPage > page.getPages()) {
            page = leaseformServer.getPage((int) page.getPages(), pageSize, leaseform);
        }
        return new R(true, page);
    }

    //    更改单个
    @PutMapping
    public R updateById(@RequestBody Leaseform leaseform) {
        return new R(true, leaseformServer.updateById(leaseform));
    }

    @PutMapping("/{state}/{id}")
    public R updatestate(@PathVariable Integer state,@PathVariable Integer id){
        return new R(true,leaseformServer.updatestate(state,id));
    }

    @PutMapping("/{id}")
    public R updateReturnDate(@PathVariable Integer id,@RequestBody Date date){
        return  new R(true,leaseformServer.updateReturnDate(id,date));
    }
}
