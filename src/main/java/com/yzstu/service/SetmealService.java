package com.yzstu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzstu.domain.Setmeal;
import com.yzstu.dto.SetmealDto;

import java.util.List;


/**
* @author yzz
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2022-09-07 01:59:31
*/
public interface SetmealService extends IService<Setmeal> {
//新增套餐 同时保存套餐和菜品的关联关系
    public void saveWithDish(SetmealDto setmealDto);
    //删除套餐
    public  void removeWithDish(List<Long> ids);
}
