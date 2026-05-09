package tenantservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tenantservice.entity.Tenant;
import tenantservice.repository.TenantRepository;

@Service
public class TenantService {
    private final TenantRepository repo;

    public TenantService(TenantRepository repo){
        this.repo = repo;
    }

    public Tenant create(Tenant tenant){
        return repo.save(tenant);
    }

    public List<Tenant> getAll(){
        return repo.findAll();
    }

}
