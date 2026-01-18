package com.glory.employeeBackend.serviceImpl;

import org.springframework.stereotype.Service;

import com.glory.employeeBackend.dto.EmployeeDTO;
import com.glory.employeeBackend.entity.Employee;
import com.glory.employeeBackend.mapper.EmployeeMapper;
import com.glory.employeeBackend.repository.EmployeeRepository;
import com.glory.employeeBackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService{

    // Injecting dependencies
    private EmployeeRepository employeeRepository;

    // Instead of creating the constructor manually, we use annotation up.

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        /** To create an employee, we need to convert the DTO to an entity, 
         * save it in the repository, so it will be stored into the db and then return the DTO.*/
        Employee employee = EmployeeMapper.mapToEmployeeJpaEntity(employeeDTO);

         // Save the employee entity into the database, the left side is call "Local Varaible"
         Employee savedEmployee = employeeRepository.save(employee);



            // Now we need to convert the saved employee entity back to DTO and return it.
         return EmployeeMapper.mapToEmplyeeDTO(savedEmployee);

    }
}

