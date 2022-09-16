package com.yzstu.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yzz
* @description 针对表【order_detail(订单明细表)】的数据库操作Mapper
* @createDate 2022-09-14 15:34:57
* @Entity generator.domain.OrderDetail
*/
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {


}
