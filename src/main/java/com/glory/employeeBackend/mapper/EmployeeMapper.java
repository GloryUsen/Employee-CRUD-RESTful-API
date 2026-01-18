package com.glory.employeeBackend.mapper;

import com.glory.employeeBackend.dto.EmployeeDTO;
import com.glory.employeeBackend.entity.Employee;

public class EmployeeMapper {
    // This method maps employee JPA entity to employeeDTO.
    public static EmployeeDTO mapToEmplyeeDTO(Employee employee){

        return new EmployeeDTO(
            /** Getting all the employeeDTO fields from the JPA and setting the fields to employeeDTO.
             * So this will map all the employee JPA entity to employee DTO.
            */

            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
}

// This method maps employeeDTO toemployee JPA entity.

public static Employee mapToEmployeeJpaEntity(EmployeeDTO employeeDto){

    return new Employee(
        employeeDto.getId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getEmail()
    );

}

}
