package com.saas.tenantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.tenantservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
