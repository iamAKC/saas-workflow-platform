package tenantservice.controller;

import org.springframework.web.bind.annotation.RestController;

import tenantservice.entity.Tenant;
import tenantservice.repository.TenantRepository;
import tenantservice.service.TenantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    public final TenantService tenantService;

    public TenantController(TenantService service){
        this.tenantService = service;
    }

    @PostMapping
    public Tenant create(@RequestBody Tenant tenant) {
        
        return tenantService.create(tenant);
    }

    @GetMapping
    public List<Tenant> getAll() {
        return tenantService.getAll();
    }
    
    

}
