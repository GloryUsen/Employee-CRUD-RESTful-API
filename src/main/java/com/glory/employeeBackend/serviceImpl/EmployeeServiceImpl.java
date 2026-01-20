package com.glory.employeeBackend.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.glory.employeeBackend.dto.EmployeeDTO;
import com.glory.employeeBackend.entity.Employee;
import com.glory.employeeBackend.exception.ResourceNotFoundException;
import com.glory.employeeBackend.mapper.EmployeeMapper;
import com.glory.employeeBackend.repository.EmployeeRepository;
import com.glory.employeeBackend.service.EmployeeService;



@Service

public class EmployeeServiceImpl  implements EmployeeService{

    // Injecting dependencies
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Instead of creating the constructor manually, we use annotation up.

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        /** To create an employee, we need to convert the DTO to an entity, 
         * save it in the repository, so it will be stored into the db and then return the DTO.*/
        Employee employee = EmployeeMapper.mapToEmployeeJpaEntity(employeeDTO);

         // Save the employee entity into the database, the left side is call "Local Varaible"
         Employee savedEmployee = employeeRepository.save(employee);



            // Now we need to convert the saved employee entity back to DTO and return it.
         return EmployeeMapper.mapToEmployeeDTO(savedEmployee);

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        /**  Before implemting the method, first create custom exception class, whenever an employee with a given
         *  id dosn't exist in the db, the program throws an exception error message. */

         Employee employee = employeeRepository.findById(employeeId)
         .orElseThrow(() -> 
         new ResourceNotFoundException("Employee doesn't exist with the given id: " + employeeId));


         // Converting JPA entity into DTO and return it.
        return EmployeeMapper.mapToEmployeeDTO(employee);
}

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

     return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
     .collect(Collectors.toList());
}

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
       Employee employee =  employeeRepository.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException(
        "The mployee with the given id is not found:" + employeeId
       ));

// Setting all the fields or details of the updatedEmployee 

       employee.setFirstName(updatedEmployee.getFirstName());
       employee.setLastName(updatedEmployee.getLastName());
       employee.setEmail(updatedEmployee.getEmail());

       Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee With the given id is not found:" + employeeId));
         employeeRepository.deleteById(employeeId);
    


}

}

