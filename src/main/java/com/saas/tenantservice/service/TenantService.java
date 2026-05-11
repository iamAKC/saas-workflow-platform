package com.saas.tenantservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saas.tenantservice.dto.TenantRequestDto;
import com.saas.tenantservice.dto.TenantResponseDto;
import com.saas.tenantservice.entity.Tenant;
import com.saas.tenantservice.repository.TenantRepository;

@Service
public class TenantService {
    private final TenantRepository repo;

    public TenantService(TenantRepository repo){
        this.repo = repo;
    }

    // public Tenant create(Tenant tenant){
    //     return repo.save(tenant);
    // }

    // public List<Tenant> getAll(){
    //     return repo.findAll();
    // }

    public TenantResponseDto create(TenantRequestDto dto){
        Tenant tenant = new Tenant();
        tenant.setName(dto.name);
        tenant.setEmail(dto.email);

        Tenant saved = repo.save(tenant);
        TenantResponseDto res = new TenantResponseDto();
        res.id = saved.getId();
        res.name= saved.getName();
        res.email= saved.getEmail();

        return res;

    }

    public List<TenantResponseDto> getAll(){
        return repo.findAll().stream().map(tenant->{
            TenantResponseDto res = new TenantResponseDto();
            res.id = tenant.getId();
            res.name = tenant.getName();
            res.email = tenant.getEmail();
            return res;
        }).toList();
    }

}
