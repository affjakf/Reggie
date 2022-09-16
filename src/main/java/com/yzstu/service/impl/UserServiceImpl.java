package com.yzstu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzstu.domain.User;
import com.yzstu.mapper.UserMapper;
import com.yzstu.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author yzz
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2022-09-12 10:50:33
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService {

}
