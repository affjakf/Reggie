package com.yzstu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yzstu.domain.Orders;

/**
* @author yzz
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2022-09-14 15:34:57
*/
public interface OrdersService extends IService<Orders> {

    void submit(Orders orders);
}
