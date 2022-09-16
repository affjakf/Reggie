package com.yzstu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yzstu.comon.CustomException;
import com.yzstu.domain.Category;
import com.yzstu.domain.Dish;
import com.yzstu.domain.Setmeal;
import com.yzstu.service.CategoryService;
import com.yzstu.mapper.CategoryMapper;
import com.yzstu.service.DishService;
import com.yzstu.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yzz
 * @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
 * @createDate 2022-09-05 03:54:07
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    //根据id删除分类
    @Override
    public void remove(Long id) {
        //查询当前分类是否关联了菜品 如果关联 则抛出异常
        LambdaQueryWrapper<Dish> dishqueryWrapper = new LambdaQueryWrapper<>();
        dishqueryWrapper.eq(Dish::getCategoryId, id);
        int count = dishService.count(dishqueryWrapper);
        if (count > 0) {
    //说明有关联的菜品
            throw  new CustomException("当前分类下关联了菜品，不能删除");
        }
        //查询当前分类是否关联了套餐
        LambdaQueryWrapper<Setmeal> setmealqueryWrapper = new LambdaQueryWrapper<>();
        setmealqueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealqueryWrapper);
        if (count2 > 0) {
            //说明有关联的套餐
            throw  new CustomException("当前分类下关联了套餐，不能删除");
        }
        //正常删除 分类
        super.removeById(id);
    }
}
