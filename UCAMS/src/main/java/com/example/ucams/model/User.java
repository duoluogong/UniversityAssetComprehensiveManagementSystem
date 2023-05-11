package com.example.ucams.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    @TableId
    //在使用MyBatis-plus自带的删除和更新方法时，它都是通过ID来进行删除和更新，
    // 而我们的实体类没有id这个字段。
    //所以使用这个注解( @TableId)使得mp将我们自己的主键userid识别为id
    private Integer userId;
    private String userName;
    private String userPwd;
    private String academyId;
    private String userPower;
    private String userPhone;
}
