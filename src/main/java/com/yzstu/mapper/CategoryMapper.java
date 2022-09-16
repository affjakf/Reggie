package com.yzstu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.Category;
import org.apache.ibatis.annotations.Mapper;


/**
* @author yzz
* @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
* @createDate 2022-09-05 03:54:07
* @Entity com.yzstu.domain.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {


}
