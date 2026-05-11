package com.saas.tenantservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saas.tenantservice.dto.UserRequestDto;
import com.saas.tenantservice.dto.UserResponseDto;
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

    // public User createUser(Long tenantId, User user){
    //     Tenant tenant = tenantRepo.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
    //     user.setTenant(tenant);
    //     return userRepo.save(user);
    // }

    public UserResponseDto createUser(Long tenantId, UserRequestDto userDto){
        Tenant tenant = tenantRepo.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
        User user = new User();
        user.setName(userDto.name);
        user.setEmail(userDto.email);
        user.setRole(userDto.role);
        user.setTenant(tenant);
        User userResp = userRepo.save(user);
        UserResponseDto respDto = new UserResponseDto();
        respDto.id = userResp.getId();
        respDto.name = userResp.getName();
        respDto.email = userResp.getEmail();
        respDto.role = userResp.getRole();
        return respDto;
    }

    public List<UserResponseDto> getUsersByTenant(Long tenantId){
        return userRepo.findByTenantId(tenantId).stream().map(user-> {
            UserResponseDto userRespDto = new UserResponseDto();
            userRespDto.id = user.getId();
            userRespDto.name = user.getName();
            userRespDto.email = user.getEmail();
            userRespDto.role = user.getRole();
            return userRespDto;
        }).toList();
    }

    public List<UserResponseDto> getAll(){
        return userRepo.findAll().stream().map(user-> {
            UserResponseDto userRespDto = new UserResponseDto();
            userRespDto.id = user.getId();
            userRespDto.name = user.getName();
            userRespDto.email = user.getEmail();
            userRespDto.role = user.getRole();
            return userRespDto;
        }).toList();
    }

}
