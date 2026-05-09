package tenantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tenantservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
