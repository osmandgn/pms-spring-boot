package com.enoca.pms.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyUpdateRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    private String address;
    private String website;
    private String industry;

}
