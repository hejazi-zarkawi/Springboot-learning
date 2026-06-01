package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.controllers;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.dto.EmployeeDTO;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.entities.EmployeeEntity;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping(path = "/getSecretMessage")
    public String getEmployeeSecretMessage(){
        return "Secret message is : jndbfvuqu237t2372@%$@%%$#^hbhbwfji";
    }
    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployee(@PathVariable(name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    @GetMapping
    public List<EmployeeEntity> getAllEmployee(@RequestParam(required=false) Integer age) {
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }

}
