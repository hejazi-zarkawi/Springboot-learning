package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.services;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.dto.EmployeeDTO;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.entities.EmployeeEntity;
import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }


    public Optional<EmployeeDTO> getEmployee(Long id) {
        return employeeRepository.findById(id)
                .map(employeeEntity -> {
                   return mapper.map(employeeEntity,EmployeeDTO.class);
                });
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

    public Optional<EmployeeDTO> updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id)
                .map((existingEmployee)->{
                    mapper.map(employeeDTO,existingEmployee);
                    existingEmployee.setId(id);
                    EmployeeEntity savedEmployee= employeeRepository.save(existingEmployee);

                    return mapper.map(existingEmployee,EmployeeDTO.class);
                });

    }

    private boolean isEmployeeExist(Long id) {
        return employeeRepository.existsById(id);
    }

    public Boolean deleteEmployeeById(Long id) {
        boolean isExist= isEmployeeExist(id);
        if(isExist){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public EmployeeDTO partialUpdateEmployee(Long id, Map<String,Object> employeeDTO) {
        boolean isExist= isEmployeeExist(id);
        if(!isExist){
            return null;
        }

        EmployeeEntity employeeEntity= employeeRepository.findById(id).get();
        employeeDTO.forEach((field,value)->{
            Field fieldToBeUpdated= ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });

        return mapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
