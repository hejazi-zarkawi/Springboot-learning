package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.dto;

import com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.annotations.ValidGmail;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name cannot be empty. Enter a valid name")
    @Size(min = 3, max = 16, message = "The length of characters should be in between 3 to 16")
    private String name;

    @NotNull
//    @Email(message = "Enter a valid email")
//    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Email should have a gmail address")
    @ValidGmail
   private String email;

    @Max(value = 60,message = "Age should be less than 60")
    @Min(value = 18, message = "Age should be greater than 18")
   private Integer age;

    @Past(message = "You cannot give future dates or present date")
   private LocalDate dateofjoining;
   private Boolean isActive;

    public EmployeeDTO(){}

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateofjoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateofjoining = dateofjoining;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(LocalDate dateofjoining) {
        this.dateofjoining = dateofjoining;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        this.isActive = active;
    }
}
