package com.example.ucams.contraller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ucams.model.AssetDetails;
import com.example.ucams.model.Leaseform;
import com.example.ucams.model.Procure;
import com.example.ucams.servers.LeaseformServer;
import com.example.ucams.servers.ProcureServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("procure")
public class ProcureContraller {
    @Autowired
    private ProcureServer procureServer;

    @PostMapping
    public R save(@RequestBody Procure procure) {
        return new R(true, procureServer.save(procure));
    }

    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return new R(true, procureServer.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, procureServer.getById(id));
    }

    @PutMapping
    public R updateById(@RequestBody Procure procure) {
        return new R(true, procureServer.updateById(procure));
    }


    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Procure procure) {
        IPage<Procure> page = procureServer.getPage(currentPage, pageSize, procure);
        //为了防止删除末页最后一个数据时页面出现的的无数据显示
        if (currentPage > page.getPages()) {
            page = procureServer.getPage((int) page.getPages(), pageSize, procure);
        }
        return new R(true, page);
    }
}
