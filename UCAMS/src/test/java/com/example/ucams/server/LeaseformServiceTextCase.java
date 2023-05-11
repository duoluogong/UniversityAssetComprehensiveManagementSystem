package com.example.ucams.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ucams.model.Leaseform;
import com.example.ucams.servers.LeaseformServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeaseformServiceTextCase {
    @Autowired
    private LeaseformServer leaseformServer;

    @Test
        //查询全部
    void getAll() {
        System.out.println(leaseformServer.getAll());
    }

    @Test
    void getPageText() {
        IPage<Leaseform> page = leaseformServer.getPage(1, 5);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
    }
}
