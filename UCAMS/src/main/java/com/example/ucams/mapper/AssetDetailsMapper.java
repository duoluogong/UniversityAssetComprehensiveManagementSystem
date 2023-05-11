package com.example.ucams.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ucams.model.AssetDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface AssetDetailsMapper extends BaseMapper<AssetDetails> {

    Boolean updateForlease(Integer surplus, Integer aid);

}
