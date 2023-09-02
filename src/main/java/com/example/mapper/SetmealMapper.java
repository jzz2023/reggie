package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {

    @Update("update setmeal set status = #{status} where id = #{id}")
    void updateStatus(@Param("status") int status, @Param("id") Long id);
}
