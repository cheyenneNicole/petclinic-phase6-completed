package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetWithOwner;
import com.example.petclinic.service.OwnerServiceProxy;
import com.example.petclinic.service.PetService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("pet")
public class PetController implements BasicController<Pet> {

    private static final Logger logger = LoggerFactory.getLogger(PetController.class.getName());

    private PetService petService;
    @Autowired
    private final OwnerServiceProxy ownerServiceProxy;

    public PetController(PetService petService, OwnerServiceProxy ownerServiceProxy) {

        this.petService = petService;
        this.ownerServiceProxy = ownerServiceProxy;
    }

    @Override
    @PostMapping(value = "addPet", produces = "application/json")
    public Pet add(@RequestBody Pet pet) {

        String petName = pet.getName();
        logger.info(new StringBuilder().append("Adding pet [").append(petName).append("].").toString());

        return this.petService.add(pet);
    }

    @Override
    @GetMapping(value = "getPetById/{id}", produces = "application/json")
    public PetWithOwner get(@PathVariable("id") Long id) {
        PetWithOwner petWithOwner = new PetWithOwner();
        petWithOwner.setPet(this.petService.get(id));

        Owner owner = ownerServiceProxy.getOwnerById(petWithOwner.getOwnerId());

        petWithOwner.setOwner(owner);

        return petWithOwner;
    }

    @Override
    @PutMapping(value = "updatePet", produces = "application/json")
    public Pet modify(@RequestBody Pet pet) {

        String petName = pet.getName();
        logger.info(new StringBuilder().append("Updating pet [").append(petName).append("].").toString());

        return this.petService.modify(pet);
    }

    @Override
    @DeleteMapping(value = "deletePet", produces = "application/json")
    public boolean delete(@RequestBody Pet pet) {

        return this.petService.delete(pet);
    }

    @Override
    @GetMapping(value = "getAllPets", produces = "application/json")
    public List<Pet> getAll() {

        return this.petService.getAll();

    }

    @GetMapping(value = "getAllPetsByOwner/{ownerId}", produces = "application/json")
    public List<Pet> getAllPetsForOwner(@PathVariable("ownerId") Long ownerId) {

        return this.petService.getAllPetsForOwner(ownerId);
    }

    @GetMapping(value = "getPetByName/{name}", produces = "application/json")
    public List<Pet> getPetByName(@PathVariable("name") String name) {

        return this.petService.getPetByName(name);
    }
}
