package com.saas.tenantservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.saas.tenantservice.dto.ApiResponse;
import com.saas.tenantservice.dto.TenantRequestDto;
import com.saas.tenantservice.dto.TenantResponseDto;
import com.saas.tenantservice.entity.Tenant;
import com.saas.tenantservice.repository.TenantRepository;
import com.saas.tenantservice.service.TenantService;

import jakarta.validation.Valid;

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

    // @PostMapping
    // public TenantResponseDto create(@Valid @RequestBody TenantRequestDto tenant) {
    //     return service.create(tenant);
    // }
    @PostMapping
    public ApiResponse<TenantResponseDto> create(@Valid @RequestBody TenantRequestDto tenant) {
        TenantResponseDto result = service.create(tenant);
        return new ApiResponse<>("Success", result, "Tenant created successfully");
    }

    // @GetMapping
    // public List<TenantResponseDto> getAll() {
    //     return service.getAll();
    // }
    @GetMapping
    public ApiResponse<List<TenantResponseDto>> getAll() {
        List<TenantResponseDto> list = service.getAll();
        return new ApiResponse<>("Success", list, "Tenants fetched successfully");
    }

}
