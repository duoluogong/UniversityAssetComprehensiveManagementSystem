package com.example.ucams.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Leaseform {
    @TableId
    private Integer leaseformId;
    private String userId;
    private String userName;
    private Integer uacademyId;
    private String userPhone;
    private String assetId;
    private String assetName;
    private Integer categoryId;
    private Integer academyId;
    private Integer surplus;
    private String leaseNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//一个用于标准化时间显示格式的注解
    private Date leaseDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returnDate;
    private Integer state;
//    外联数据


}
