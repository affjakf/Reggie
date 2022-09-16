package com.yzstu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yzz
* @description 针对表【shopping_cart(购物车)】的数据库操作Mapper
* @createDate 2022-09-14 13:01:53
* @Entity generator.domain.ShoppingCart
*/
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {


}
