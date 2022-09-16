package com.yzstu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.AddressBook;
import org.apache.ibatis.annotations.Mapper;


/**
* @author yzz
* @description 针对表【address_book(地址管理)】的数据库操作Mapper
* @createDate 2022-09-03 11:55:39
* @Entity com.yzstu.domain.AddressBook
*/
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {


}
