package com.example.petclinic.repository;

import com.example.petclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitRepository extends CrudRepository<Visit, Long> {

    List<Visit> findVisitByPetId(Long petId);
}
