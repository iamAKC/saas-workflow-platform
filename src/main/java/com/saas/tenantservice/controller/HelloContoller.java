package com.saas.tenantservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloContoller {
    @GetMapping
    public String hello(){
       return "Tenant Service is running"; 
    }

}
