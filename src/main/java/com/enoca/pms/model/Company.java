package com.enoca.pms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "t_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Company name can not be null")
    @Size(min = 1, max = 50, message = "Company name '${validatedValue}' must be between {min} and {max} chars long")
    private String name;

    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;


    private String address;

    private String website;

    private String industry;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Employee> employees;
}
