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

// This method maps employeeDTO to employee JPA entity.

public static Employee mapToEmployeeJpaEntity(EmployeeDTO employeeDTO){

    return new Employee(
        employeeDTO.getId(),
        employeeDTO.getFirstName(),
        employeeDTO.getLastName(),
        employeeDTO.getEmail()
    );

}

}
