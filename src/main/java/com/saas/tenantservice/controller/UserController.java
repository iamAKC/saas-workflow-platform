package com.saas.tenantservice.controller;

import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/tenants/{tenantId}/users")
    public UserResponseDto createUser(@PathVariable Long tenantId, @RequestBody UserRequestDto user) {
        return service.createUser(tenantId, user);
    }

    @GetMapping("/tenants/{tenantId}/users")
    public List<UserResponseDto> getUsersByTenant(@PathVariable Long tenantId) {
        return service.getUsersByTenant(tenantId);
    }

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers() {
        return service.getAll();
    }
    
}
