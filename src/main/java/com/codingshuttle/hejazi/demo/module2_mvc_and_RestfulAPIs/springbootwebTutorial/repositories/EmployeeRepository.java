package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.repositories;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
