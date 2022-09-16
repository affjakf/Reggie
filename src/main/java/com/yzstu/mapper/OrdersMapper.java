package com.yzstu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.Orders;
import org.apache.ibatis.annotations.Mapper;


/**
* @author yzz
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @createDate 2022-09-14 15:34:57
* @Entity generator.domain.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {


}
