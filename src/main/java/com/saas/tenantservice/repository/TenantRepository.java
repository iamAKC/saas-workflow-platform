package com.saas.tenantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.tenantservice.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
