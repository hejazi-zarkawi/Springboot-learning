package com.codingshuttle.hejazi.demo;

import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.CPatientInfo;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
////
//        for(var p: patientList) {
//            System.out.println(p);
//        }

        int rowsAffected = patientRepository.updatePatientNameWithId("Anuj Sharma", 1L);
//
        System.out.println(rowsAffected);

    }
}
