package com.example.petclinic.controller;


import com.example.petclinic.models.Visit;
import com.example.petclinic.service.VisitService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("visit")
public class VisitController implements BasicController<Visit> {

    private VisitService visitService;

    public VisitController(VisitService visitService) {

        this.visitService = visitService;
    }

    @Override
    @PostMapping(value = "addVisit", produces = "application/json")
    public Visit add(@RequestBody Visit visit) {

        return this.visitService.add(visit);
    }

    @Override
    @GetMapping(value = "getVisitById/{id}", produces = "application/json")
    public Visit get(@PathVariable("id") Long id) {
        Visit visit = this.visitService.get(id);

        return visit;
    }

    @Override
    @PutMapping(value = "modifyVisit", produces = "application/json")
    public Visit modify(@RequestBody Visit visit) {

        return this.visitService.modify(visit);
    }

    @Override
    @DeleteMapping(value = "deleteVisit", produces = "application/json")
    public boolean delete(@RequestBody Visit visit) {

        return this.visitService.delete(visit);
    }

    @Override
    @GetMapping(value = "getAllVisits", produces = "application/json")
    public List<Visit> getAll() {

        List<Visit> visits = this.visitService.getAll();
        return visits;

    }

    @GetMapping("getVisitsByPetName")
    public List<Visit> getVisitsByPetName(@RequestBody Long petId) {
        return this.visitService.getVisitsByPetId(petId);
    }
}
