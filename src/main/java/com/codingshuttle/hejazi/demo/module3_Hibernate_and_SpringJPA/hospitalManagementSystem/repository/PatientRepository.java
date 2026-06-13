package com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.repository;

import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.CPatientInfo;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.IPatientInfo;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("select new com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.CPatientInfo(p.id, p.name) " +
            "from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto.BloodGroupStats(p.bloodGroup, " +
            "COUNT(p)) from Patient p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);
}
