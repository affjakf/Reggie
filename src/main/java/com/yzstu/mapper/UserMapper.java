package com.yzstu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author yzz
* @description 针对表【user(用户信息)】的数据库操作Mapper
* @createDate 2022-09-12 10:50:33
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
