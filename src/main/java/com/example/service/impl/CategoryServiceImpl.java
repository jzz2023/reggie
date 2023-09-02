package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.CustomException;
import com.example.mapper.CategoryMapper;
import com.example.pojo.Category;
import com.example.pojo.Dish;
import com.example.pojo.Setmeal;
import com.example.service.CategoryService;
import com.example.service.DishService;
import com.example.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        log.info("当前id：{}",id);
        LambdaQueryWrapper<Dish> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Dish::getCategoryId,id);
        long count1 = dishService.count(lqw);

        //查询当前分类是否关联菜品
        if(count1>0){
            throw new CustomException("当前分类已关联菜品，无法删除");
        }
        LambdaQueryWrapper<Setmeal> setmealqw = new LambdaQueryWrapper<>();
        setmealqw.eq(Setmeal::getCategoryId,id);
        long count2 = setmealService.count(setmealqw);
        //查询当前分类是否关联套餐
        if(count2>0){
            throw new CustomException("当前分类已关联套餐，无法删除");
        }
        super.removeById(id);
    }
}
