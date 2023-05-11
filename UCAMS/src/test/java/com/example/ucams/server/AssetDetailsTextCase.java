package com.example.ucams.server;

import com.example.ucams.model.AssetDetails;
import com.example.ucams.servers.AssetDetailsServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Date;

@SpringBootTest
public class AssetDetailsTextCase {

    @Autowired
    private AssetDetailsServer assetDetailsServer;

    @Test
    void getByIdTest() {
        System.out.println(assetDetailsServer.getById(1));
    }

    @Test
    void saveTest() {
        Date date = new Date();
        date.setTime(date.getTime());
        AssetDetails assetDetails = new AssetDetails();
        assetDetails.setAssetName("激光打印机111");
        assetDetails.setCategoryId("设备");
        assetDetails.setState(1);
        assetDetails.setWarehousingTime(date);
        assetDetails.setInventory(111);
        System.out.println(assetDetails);
        assetDetailsServer.save(assetDetails);
    }

    @Test
    void getAllTest() {
        System.out.println(assetDetailsServer.list());
    }

    @Test
    void updataTest() {
        Date date = new Date();
        date.setTime(date.getTime());
        AssetDetails assetDetails = new AssetDetails();
        assetDetails.setAssetId(4);
        assetDetails.setAssetName("激光打印机");
        assetDetails.setCategoryId("设备");
        assetDetails.setState(1);
        assetDetails.setWarehousingTime(date);
        assetDetails.setInventory(121);
        System.out.println(assetDetails);
        assetDetailsServer.updateById(assetDetails);
    }

    @Test
    void removeTest() {
        assetDetailsServer.removeById(4);
    }

    @Test
    void updateForlease() {
        Integer num = 10;
        Integer aid = 1;
        assetDetailsServer.updateForlease(num, aid);
    }
}

