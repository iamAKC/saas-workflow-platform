package tenantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tenantservice.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
