package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.services;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.dto.EmployeeDTO;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.entities.EmployeeEntity;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }


    public EmployeeDTO getEmployee(Long id) {
        EmployeeEntity employee= employeeRepository.findById(id).orElse(null);
        return mapper.map(employee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee() {
         List<EmployeeEntity> employees= employeeRepository.findAll();
         return employees.stream()
                 .map(employee -> mapper.map(employee, EmployeeDTO.class))
                 .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity= mapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity createdEmployee= employeeRepository.save(toSaveEntity);
        return mapper.map(createdEmployee, EmployeeDTO.class);
    }
}
