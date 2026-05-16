package com.saas.tenantservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.saas.tenantservice.dto.ApiResponse;
import com.saas.tenantservice.dto.UserRequestDto;
import com.saas.tenantservice.dto.UserResponseDto;
import com.saas.tenantservice.entity.User;
import com.saas.tenantservice.service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    // @PostMapping("/tenants/{tenantId}/users")
    // public UserResponseDto createUser(@PathVariable Long tenantId, @RequestBody UserRequestDto user) {
    //     return service.createUser(tenantId, user);
    // }
    @PostMapping("/tenants/{tenantId}/users")
    public ApiResponse<UserResponseDto> createUser(@PathVariable Long tenantId, @RequestBody UserRequestDto user) {
        UserResponseDto result = service.createUser(tenantId, user);
        return new ApiResponse<>("Success", result, "User created successfully");
    }

    @GetMapping("/tenants/{tenantId}/users")
    public ApiResponse<List<UserResponseDto>> getUsersByTenant(@PathVariable Long tenantId) {
        List<UserResponseDto> list = service.getUsersByTenant(tenantId);
        return new ApiResponse<>("Success", list, "User fetched successfully");
    }

    @GetMapping("/users")
    public ApiResponse<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> list = service.getAll();
        return new ApiResponse<>("Success", list, "User fetched successfully");
    }
    
}
