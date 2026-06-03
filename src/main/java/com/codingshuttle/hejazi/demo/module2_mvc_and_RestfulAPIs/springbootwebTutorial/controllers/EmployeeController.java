package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.controllers;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.dto.EmployeeDTO;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.entities.EmployeeEntity;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.repositories.EmployeeRepository;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }


    @GetMapping(path = "/getSecretMessage")
    public String getEmployeeSecretMessage(){
        return "Secret message is : jndbfvuqu237t2372@%$@%%$#^hbhbwfji";
    }
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployee(id);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployee(@RequestParam(required=false) Integer age) {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

}
