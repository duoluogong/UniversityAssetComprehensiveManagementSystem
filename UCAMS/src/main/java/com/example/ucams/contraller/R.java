package com.example.ucams.contraller;

import lombok.Data;

@Data
public class R {//为统一数据格式而创建的一个类
    private Boolean flag;//操作结果
    private Object data;//数据

    //增删改
    public R(Boolean flag) {
        this.flag = flag;
    }

    //查询
    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
