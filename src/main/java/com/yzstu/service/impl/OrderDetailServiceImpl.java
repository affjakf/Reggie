package com.yzstu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzstu.domain.OrderDetail;
import com.yzstu.mapper.OrderDetailMapper;
import com.yzstu.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
* @author yzz
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2022-09-14 15:34:57
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
implements OrderDetailService {

}
