package com.enoca.pms.dto;

import com.enoca.pms.model.Employee;
import lombok.Data;

import java.util.List;

@Data
public class CompanyDTO {

    private String name;
    private String email;
    private String address;
    private String website;
    private String industry;
}
