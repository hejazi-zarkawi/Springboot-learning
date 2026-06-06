package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.controllers;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.dto.EmployeeDTO;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.entities.EmployeeEntity;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.exceptions.ResourceNotFoundException;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.repositories.EmployeeRepository;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(name = "employeeId") Long id) {
         Optional<EmployeeDTO> employeeDTO= employeeService.getEmployee(id);
         return employeeDTO.map(employeeDTO1 -> {
             return ResponseEntity.ok(employeeDTO1);
         }).orElseThrow(()-> new ResourceNotFoundException("Element not Found with id: "+id));

    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestParam(required=false) Integer age) {
        List<EmployeeDTO> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        EmployeeDTO createdEmployee= employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employee=  employeeService.updateEmployeeById(id,employeeDTO);
        return employee.map(employeeDTO1 -> {
            return ResponseEntity.ok(employeeDTO1);})
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name = "employeeId") Long id){
        Boolean result= employeeService.deleteEmployeeById(id);
        if(result){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> partialUpdateEmployee(@RequestBody Map<String,Object> employeeDTO, @PathVariable(name = "employeeId") Long id){
            EmployeeDTO employee= employeeService.partialUpdateEmployee(id,employeeDTO);
            if(employee==null){
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(employee);
    }

}
