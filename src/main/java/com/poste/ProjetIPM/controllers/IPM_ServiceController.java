package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_EntityRepository;
import com.poste.ProjetIPM.Repository.IPM_ServiceRepository;
import com.poste.ProjetIPM.entities.IPM_Entity;
import com.poste.ProjetIPM.entities.IPM_Service;
import com.poste.ProjetIPM.services.IPM_ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_ServiceController {

    @Autowired
    IPM_ServiceService ipm_serviceService;

    @Autowired
    IPM_EntityRepository ipm_entityRepository;

    @GetMapping("/service")
    public Collection<IPM_Service> getAll() {
        return ipm_serviceService.getAll();
    }

    @GetMapping("/service/{id}")
    public IPM_Service getById(@PathVariable Long id) {
        return ipm_serviceService.getById(id);
    }

    @PostMapping("/service")
    public void save(@RequestBody IPM_Service ipm_service) {
        IPM_Entity ipm_entity = new IPM_Entity();
        ipm_entity = ipm_service.getIpm_entity();
        ipm_service.setIpm_entity(ipm_entityRepository.findById(ipm_entity.getIdEntity()).get());
        ipm_serviceService.save(ipm_service);
    }

    @PutMapping("/service")
    public void update(@RequestBody IPM_Service ipm_service) {
        ipm_serviceService.update(ipm_service);
    }

    @DeleteMapping("/service/{id}")
    public void delete(@PathVariable Long id) {
        ipm_serviceService.delete(id);
    }
}
