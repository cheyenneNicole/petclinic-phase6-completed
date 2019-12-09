package com.example.petclinic.business;


import com.example.petclinic.model.*;
import com.example.petclinic.service.OwnerService;

import com.example.petclinic.service.PetService;
import com.example.petclinic.service.VetService;
import com.example.petclinic.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PetClinicBuisnessWorkflow {

    private static final Logger log = LoggerFactory.getLogger(PetClinicBuisnessWorkflow.class.getName());

    private OwnerService ownerService;
    private PetService petService;
    private VisitService visitService;
    private VetService vetService;

    public PetClinicBuisnessWorkflow(OwnerService ownerService, PetService petService, VisitService visitService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.visitService = visitService;
        this.vetService = vetService;
    }

    public void runBusiness() {

        /*
        Owners
         */

        // Create Owners
        Owner owner1 = Owner.builder().withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner2 = Owner.builder().withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner3 = Owner.builder().withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner4 = Owner.builder().withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();

        // saveOwner
        ownerService.saveOwner(owner1);
        ownerService.saveOwner(owner2);
        ownerService.saveOwner(owner3);
        ownerService.saveOwner(owner4);

        // getAllOwners
        List<Owner> owners = ownerService.getAllOwners();
        owners.forEach(owner -> log.info(owner.toString()));

        // getOwnerByName
        final String searchFor = "Homer Simpson";
        List<Owner> homers = ownerService.getOwnerByName(searchFor);

        final AtomicInteger counter = new AtomicInteger(1);
        homers.forEach(homer -> {

            StringBuilder sb = new StringBuilder();
            sb.append(searchFor);
            sb.append(" ");
            sb.append(counter.getAndIncrement());
            sb.append(": ");
            sb.append(homer);

            log.info(sb.toString());
        });

        /*
        Pets
         */

        Owner homer = null;
        if (!homers.isEmpty()) {
            homer = homers.get(0);
        }

        String target = "Marge Simpson";
        List<Owner> marges = ownerService.getOwnerByName(target);
        Owner marge = null;
        if (!marges.isEmpty()) {
            marge = marges.get(0);
        }

        target = "Bart Simpson";
        List<Owner> barts = ownerService.getOwnerByName(target);
        Owner bart = null;
        if (!barts.isEmpty()) {
            bart = barts.get(0);
        }

        target = "Lisa Simpson";
        List<Owner> lisas = ownerService.getOwnerByName(target);
        Owner lisa = null;
        if (!lisas.isEmpty()) {
            lisa = lisas.get(0);
        }

        // Pets for Homer
        Pet pet1 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).withOwnerId(homer.getId()).build();
        Pet pet2 = Pet.builder().withName("Mojo").withBirthDate(new Date()).withPetType(PetType.MONKEY).withOwnerId(homer.getId()).build();
        Pet pet3 = Pet.builder().withName("Pinchy").withBirthDate(new Date()).withPetType(PetType.LOBSTER).withOwnerId(homer.getId()).build();
        Pet pet4 = Pet.builder().withName("Plopper").withBirthDate(new Date()).withPetType(PetType.PIG).withOwnerId(homer.getId()).build();

        // Pets for Marge
        Pet pet5 = Pet.builder().withName("Greyhound").withBirthDate(new Date()).withPetType(PetType.DOG).withOwnerId(marge.getId()).build();

        // Pets for Bart
        Pet pet6 = Pet.builder().withName("Laddie").withBirthDate(new Date()).withPetType(PetType.DOG).withOwnerId(bart.getId()).build();
        Pet pet7 = Pet.builder().withName("Santa's Little Helper").withBirthDate(new Date()).withPetType(PetType.DOG).withOwnerId(bart.getId()).build();
        Pet pet8 = Pet.builder().withName("Stampy").withBirthDate(new Date()).withPetType(PetType.ELEPHANT).withOwnerId(bart.getId()).build();
        Pet pet9 = Pet.builder().withName("Duncan").withBirthDate(new Date()).withPetType(PetType.HORSE).withOwnerId(bart.getId()).build();


        // Pets for Lisa
        Pet pet10 = Pet.builder().withName("Nibbles").withBirthDate(new Date()).withPetType(PetType.HAMPSTER).withOwnerId(lisa.getId()).build();
        Pet pet11 = Pet.builder().withName("Chirpy Boy").withBirthDate(new Date()).withPetType(PetType.LIZARD).withOwnerId(lisa.getId()).build();
        Pet pet12 = Pet.builder().withName("Bart Junior").withBirthDate(new Date()).withPetType(PetType.LIZARD).withOwnerId(lisa.getId()).build();
        Pet pet13 = Pet.builder().withName("Snowball IV").withBirthDate(new Date()).withPetType(PetType.CAT).withOwnerId(lisa.getId()).build();
        Pet pet14 = Pet.builder().withName("Princess").withBirthDate(new Date()).withPetType(PetType.HORSE).withOwnerId(lisa.getId()).build();

        petService.savePet(pet1);
        petService.savePet(pet2);
        petService.savePet(pet3);
        petService.savePet(pet4);
        petService.savePet(pet5);
        petService.savePet(pet6);
        petService.savePet(pet7);
        petService.savePet(pet8);
        petService.savePet(pet9);
        petService.savePet(pet10);
        petService.savePet(pet11);
        petService.savePet(pet12);
        petService.savePet(pet13);
        petService.savePet(pet14);

        List<Pet> pets = petService.getAllPets();

        pets.forEach(pet -> log.info(pet.getName()));

        List<Pet> laddie = petService.getPetByName("Laddie");

        laddie.forEach(l -> log.info(l.toString()));

        /*
        Visits
         */
        Visit visit1 = Visit.builder().withDateOfVisit(new Date()).withDescription("Nice Visit!").withPetId(pets.get(0).getId()).build();
        Visit visit2 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").withPetId(pets.get(1).getId()).build();
        Visit visit3 = Visit.builder().withDateOfVisit(new Date()).withDescription("Super Visit!").withPetId(pets.get(2).getId()).build();
        Visit visit4 = Visit.builder().withDateOfVisit(new Date()).withDescription("So-so Visit!").withPetId(pets.get(2).getId()).build();

        visitService.saveVisit(visit1);
        visitService.saveVisit(visit2);
        visitService.saveVisit(visit3);
        visitService.saveVisit(visit4);

        List<Visit> visits = visitService.getAllVisits();
        visits.forEach(visit -> log.info(visit.getPetId() + ": " + visit.getDateOfVisit() + ", " + visit.getDescription()));

        /*
        Vets
         */
        Vet vet1 = Vet.builder().withName("SuperVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withVisitId(visit1.getId()).build();
        Vet vet2 = Vet.builder().withName("SuperDuperVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withSpeciality(Speciality.RADIOLOGY).withVisitId(visit1.getId()).build();
        Vet vet3 = Vet.builder().withName("OutstandingVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withVisitId(visit4.getId()).withVisitId(visit3.getId()).withVisitId(visit2.getId()).build();

        vetService.saveVet(vet1);
        vetService.saveVet(vet2);
        vetService.saveVet(vet3);

        List<Vet> vets = vetService.getAllVets();

        vets.forEach(v -> log.info(v.toString()));

    }
}
