package com.yzstu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzstu.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
