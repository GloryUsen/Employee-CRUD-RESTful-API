package com.glory.employeeBackend.service;

import com.glory.employeeBackend.dto.EmployeeDTO;
import com.glory.employeeBackend.entity.Employee;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeId);


}
