package com.example.ucams.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class AssetDetails {
    @TableId
    private Integer assetId;
    private String assetName;
    private String categoryId;
    private String academyId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//一个用于标准化时间显示格式的注解
    private Date warehousingTime;
    private Integer inventory;
    private Integer surplus;
    private Integer repairing;
    private Integer state;
    private String note;
}
