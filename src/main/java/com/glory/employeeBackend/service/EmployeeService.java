package com.glory.employeeBackend.service;

import java.util.List;

import com.glory.employeeBackend.dto.EmployeeDTO;
import com.glory.employeeBackend.entity.Employee;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeId);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);
    void deleteEmployee(Long employeeId);


}
