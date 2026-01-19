package com.glory.employeeBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glory.employeeBackend.dto.EmployeeDTO;
import com.glory.employeeBackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")

public class EmployeeController {

    private EmployeeService employeeService;

    // Build Create employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee =  employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Employee GET Rest Api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById (@PathVariable("id") Long employeeId){
       EmployeeDTO employeeDto =  employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(employeeDto);
    
    }

}
