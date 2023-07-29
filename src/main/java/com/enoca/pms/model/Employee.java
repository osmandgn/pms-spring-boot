package com.enoca.pms.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "t_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "First name can not be null")
    @Size(min = 2, max = 50, message = "Employee first name must be between {min} and {max} chars long")
    private String firsName;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Last name can not be null")
    @Size(min = 2, max = 50, message = "Employee last name must be between {min} and {max} chars long")
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    @Email
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number must be ten digits long!")
    private String phoneNumber;


    private String jobTitle;

    private Double salary;

    @ManyToOne
    @JoinColumn
    private Company company;








}
