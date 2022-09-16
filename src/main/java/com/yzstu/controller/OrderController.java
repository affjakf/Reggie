package com.yzstu.controller;

import com.yzstu.comon.R;
import com.yzstu.domain.Orders;
import com.yzstu.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据：{}",orders);
        ordersService.submit(orders);
        return R.success("支付成功");
    }
}
