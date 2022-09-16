package com.yzstu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yzstu.comon.CustomException;
import com.yzstu.domain.Setmeal;

import com.yzstu.domain.SetmealDish;
import com.yzstu.dto.SetmealDto;
import com.yzstu.service.SetmealDishService;
import com.yzstu.service.SetmealService;
import com.yzstu.mapper.SetmealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yzz
 * @description 针对表【setmeal(套餐)】的数据库操作Service实现
 * @createDate 2022-09-07 01:59:31
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>
        implements SetmealService {


    @Autowired
    private SetmealDishService setmealDishService;

    @Override
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId().toString());
            return item;
        }).collect(Collectors.toList());
        //保存套餐的关联关系
        setmealDishService.saveBatch(setmealDishes);

    }

    @Override
    @Transactional
    public void removeWithDish(List<Long> ids) {
        //查询套餐状态是否可以删除
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);
        int count = this.count();
        //不可以删除 则抛出异常
        if (count>0){
            throw new CustomException("套餐售卖中，不能删除");
        }
        //如果可以删除 则删除套餐表中的内容
        this.removeByIds(ids);
        //删除关系表中的数据
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(lambdaQueryWrapper);
    }
}
