package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dto.DishDto;
import com.example.pojo.Dish;

public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应口味，操作两张表
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询dish和口味数据
    public DishDto getWithFlavorById(Long id);

    void updateWithFlavor(DishDto dishDto);
}
