package com.example.ucams.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ucams.model.Leaseform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface LeaseformMapper extends BaseMapper<Leaseform> {

    @Select("SELECT\n" + "	leaseform.`index`,\n" + "	leaseform.user_id,\n" + "	`user`.user_name,\n" + "	`user`.user_phone,\n" + "	`user`.academy_id,\n" + "	leaseform.asset_id,\n" + "	asset_details.asset_name,\n" + "	academy.`name`,\n" + "	category.category_name,\n" + "	asset_details.surplus,\n" + "	leaseform.lease_num,\n" + "	leaseform.lease_data,\n" + "	leaseform.state \n" + "FROM\n" + "	leaseform\n" + "	INNER JOIN `user` ON leaseform.user_id = `user`.user_id\n" + "	INNER JOIN asset_details ON leaseform.asset_id = asset_details.asset_id\n" + "	INNER JOIN category ON asset_details.category_id = category.id\n" + "	INNER JOIN academy ON asset_details.academy_id = academy.id")
    List<Leaseform> getAll();
    @Update("UPDATE leaseform set state=#{state} where leaseform_id =#{id}")
    Boolean updatestate(Integer state,Integer id);

    @Update("update leaseform set return_date = #{date} where leaseform_id =#{id}")
    Boolean updateReturnDate(Integer id,Date date);
}
