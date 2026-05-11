package com.saas.tenantservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class TenantRequestDto {

    @NotBlank
    public String name;
    
    @Email
    @NotBlank
    public String email;

}
