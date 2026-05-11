package com.saas.tenantservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.tenantservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByTenantId(Long tenantId);
}
