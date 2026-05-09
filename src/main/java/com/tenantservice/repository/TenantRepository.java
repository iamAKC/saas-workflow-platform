package com.tenantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenantservice.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
