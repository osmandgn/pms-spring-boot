package com.enoca.pms.dto;

import com.enoca.pms.model.Company;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTO {

    private String firsName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String jobTitle;
    private Double salary;
    private String companyName;
}
