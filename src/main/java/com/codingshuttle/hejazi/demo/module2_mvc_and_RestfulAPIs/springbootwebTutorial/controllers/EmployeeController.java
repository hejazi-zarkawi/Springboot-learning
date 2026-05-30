package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.controllers;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @GetMapping(path = "/getSecretMessage")
    public String getEmployeeSecretMessage(){
        return "Secret message is : jndbfvuqu237t2372@%$@%%$#^hbhbwfji";
    }
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id, "Hejazi", "hejazimohammad764@gmail.com", 24, LocalDate.of(2024, 01, 01), true);
    }
    @GetMapping
    public String getAllEmployee(@RequestParam(required=false) Integer age) {
        return "Hi!My age is :"+ age;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }

}
