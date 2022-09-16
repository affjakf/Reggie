package com.yzstu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzstu.domain.Category;


/**
* @author yzz
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2022-09-05 03:54:07
*/

public interface CategoryService extends IService<Category> {
    public void remove(Long id);

}
