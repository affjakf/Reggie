package com.yzstu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzstu.domain.DishFlavor;
import com.yzstu.service.DishFlavorService;
import com.yzstu.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author yzz
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2022-09-08 21:38:10
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
implements DishFlavorService{

}
