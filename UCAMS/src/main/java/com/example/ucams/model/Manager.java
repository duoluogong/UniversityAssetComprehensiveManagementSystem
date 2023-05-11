package com.example.ucams.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Manager {
    @TableId
    private Integer mId;
    private String mPwd;
    private String mName;
    private char mSex;
    private String mPhone;
    private String mAcademyId;
    private Integer mPower;
    private String mNote;
}
