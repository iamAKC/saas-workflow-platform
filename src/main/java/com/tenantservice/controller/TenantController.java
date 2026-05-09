package com.tenantservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tenantservice.entity.Tenant;
import com.tenantservice.repository.TenantRepository;
import com.tenantservice.service.TenantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService service;

    public TenantController(TenantService service) {
        this.service = service;
    }

    @PostMapping
    public Tenant create(@RequestBody Tenant tenant) {
        return service.create(tenant);
    }

    @GetMapping
    public List<Tenant> getAll() {
        return service.getAll();
    }

}
