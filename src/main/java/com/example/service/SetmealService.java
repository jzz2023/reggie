package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dto.SetmealDto;
import com.example.pojo.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    //新增套餐和菜品关联关系
    public void saveWithDish(SetmealDto setmealDto);

    //根据id获取菜品信息以及关联信息
    public SetmealDto getWithDish(Long id);

    //修改信息
    public void updateWithDish(SetmealDto setmealDto);

    //删除信息
    void removeWithDish(List<Long> ids);

    //修改状态
    void updateStatus(int status,List<Long> ids);
}
