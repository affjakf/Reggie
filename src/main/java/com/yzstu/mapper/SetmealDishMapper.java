package com.yzstu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.SetmealDish;
import org.apache.ibatis.annotations.Mapper;


/**
* @author yzz
* @description 针对表【setmeal_dish(套餐菜品关系)】的数据库操作Mapper
* @createDate 2022-09-10 09:34:47
* @Entity com.yzstu.domain.SetmealDish
*/
@Mapper
public interface SetmealDishMapper extends BaseMapper<SetmealDish> {


}
