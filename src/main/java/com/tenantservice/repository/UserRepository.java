package com.tenantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenantservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
