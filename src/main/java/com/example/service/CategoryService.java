package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
