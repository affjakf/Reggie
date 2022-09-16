package com.yzstu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yzstu.domain.AddressBook;
import com.yzstu.service.AddressBookService;
import com.yzstu.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author yzz
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2022-09-03 11:55:39
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
implements AddressBookService{

}
