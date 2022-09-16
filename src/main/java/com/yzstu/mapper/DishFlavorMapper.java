package com.yzstu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.DishFlavor;
import org.apache.ibatis.annotations.Mapper;


/**
* @author yzz
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Mapper
* @createDate 2022-09-08 21:38:10
* @Entity com.yzstu.domain.DishFlavor
*/
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {


}
