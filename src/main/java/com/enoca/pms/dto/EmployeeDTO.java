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

    @NotBlank(message = "First name can not be null")
    @Size(min = 2, max = 50, message = "Employee first name must be between {min} and {max} chars long")
    private String firsName;

    @NotBlank(message = "Last name can not be null")
    @Size(min = 2, max = 50, message = "Employee last name must be between {min} and {max} chars long")
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number must be ten digits long!")
    private String phoneNumber;


    private String jobTitle;

    private Double salary;

    private String companyName;
}
