package com.yzstu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzstu.domain.Employee;
import com.yzstu.mapper.EmployeeMapper;
import com.yzstu.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements  EmployeeService{
}
