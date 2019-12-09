package com.example.petclinic.repository;


import com.example.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> getPetsByOwnerId(Long ownerId);

    List<Pet> getPetByName(String name);

}
