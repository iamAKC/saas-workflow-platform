package com.saas.tenantservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDto {
    @NotBlank
    public String name;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String role;

}
