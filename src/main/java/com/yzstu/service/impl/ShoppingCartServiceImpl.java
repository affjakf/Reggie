package com.yzstu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzstu.domain.ShoppingCart;
import com.yzstu.mapper.ShoppingCartMapper;
import com.yzstu.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
* @author yzz
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2022-09-14 13:01:53
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
implements ShoppingCartService {

}
