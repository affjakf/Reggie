package com.yzstu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzstu.domain.Dish;
import com.yzstu.dto.DishDto;


/**
* @author yzz
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2022-09-07 01:58:41
*/
public interface DishService extends IService<Dish> {

    //新增菜品 同时插入菜品对应的口味数据，需要操作两张表
    public void saveWithFlavor(DishDto dishDto);
    //根据id查询菜品和对应的口味信息
    public DishDto getByIdWithFlavor( Long id);
    //更新菜品信息，同时更新对应的口味信息
    public void updateWithFlavor(DishDto dishDto);
}
