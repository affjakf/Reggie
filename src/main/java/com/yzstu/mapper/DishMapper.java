package com.yzstu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yzstu.domain.Dish;
import org.apache.ibatis.annotations.Mapper;


/**
* @author yzz
* @description 针对表【dish(菜品管理)】的数据库操作Mapper
* @createDate 2022-09-07 01:58:41
* @Entity generator.domain.Dish
*/
@Mapper
public interface DishMapper extends BaseMapper<Dish> {


}
