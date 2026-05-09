package com.tenantservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tenantservice.entity.User;
import com.tenantservice.service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/tenants/{tenantId}/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public User createUser(@PathVariable Long tenantId, @RequestBody User user) {
        
        return service.createUser(tenantId, user);
    }
    
}
