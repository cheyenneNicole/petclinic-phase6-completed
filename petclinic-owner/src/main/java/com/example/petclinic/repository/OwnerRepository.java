package com.example.petclinic.repository;

import com.example.petclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    List<Owner> findOwnerByName(String name);
}
