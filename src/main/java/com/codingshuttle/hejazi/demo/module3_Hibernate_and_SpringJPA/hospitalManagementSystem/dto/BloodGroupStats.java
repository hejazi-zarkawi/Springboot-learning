package com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.dto;

import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.hospitalManagementSystem.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
