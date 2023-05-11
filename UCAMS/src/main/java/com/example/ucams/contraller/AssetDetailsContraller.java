package com.example.ucams.contraller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ucams.model.AssetDetails;
import com.example.ucams.servers.AssetDetailsServer;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/Assets")
public class AssetDetailsContraller {
    @Autowired
    private AssetDetailsServer assetDetailsServer;

    @GetMapping
    public R getAll() {
        return new R(true, assetDetailsServer.list());
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, assetDetailsServer.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getByPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, AssetDetails asset) {
        IPage<AssetDetails> page = assetDetailsServer.getPage(currentPage, pageSize, asset);
        //为了防止删除末页最后一个数据时页面出现的的无数据显示
        if (currentPage > page.getPages()) {
            page = assetDetailsServer.getPage((int) page.getPages(), pageSize, asset);
        }
        return new R(true, page);
    }

    @PostMapping
    public R save(@RequestBody AssetDetails asset) {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        asset.setWarehousingTime(date1);
        return new R(true, assetDetailsServer.save(asset));
    }

    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return new R(true, assetDetailsServer.removeById(id));
    }

    @PutMapping("/{surplus}/{num}/{aid}")
    public R updateForlease(@PathVariable Integer surplus, @PathVariable Integer num, @PathVariable Integer aid) {
        if (num > surplus) {
            return new R(false, null);
        } else {
            surplus -= num;
            return new R(true, assetDetailsServer.updateForlease(surplus, aid));
        }

    }
    @PutMapping("/r/{surplus}/{num}/{aid}")
    public R updateForReturn(@PathVariable Integer surplus, @PathVariable Integer num, @PathVariable Integer aid) {
        Date date = new Date();
        surplus += num;
        return new R(true, assetDetailsServer.updateForlease(surplus, aid));

    }

    @PutMapping
    public R updateById(@RequestBody AssetDetails asset) {
        return new R(true, assetDetailsServer.updateById(asset));
    }
}
