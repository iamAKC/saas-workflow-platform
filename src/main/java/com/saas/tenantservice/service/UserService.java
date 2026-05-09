package com.saas.tenantservice.service;

import org.springframework.stereotype.Service;

import com.saas.tenantservice.entity.Tenant;
import com.saas.tenantservice.entity.User;
import com.saas.tenantservice.repository.TenantRepository;
import com.saas.tenantservice.repository.UserRepository;

@Service
public class UserService {
    private final TenantRepository tenantRepo;
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo, TenantRepository tRepo){
        this.tenantRepo = tRepo;
        this.userRepo = userRepo;
    }

    public User createUser(Long tenantId, User user){
        Tenant tenant = tenantRepo.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
        user.setTenant(tenant);
        return userRepo.save(user);
    }

}
