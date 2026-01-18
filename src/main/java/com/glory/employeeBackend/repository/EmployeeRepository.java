package com.glory.employeeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glory.employeeBackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
