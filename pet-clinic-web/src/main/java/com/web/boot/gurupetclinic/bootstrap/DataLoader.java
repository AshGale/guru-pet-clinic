package com.web.boot.gurupetclinic.bootstrap;

import com.web.boot.gurupetclinic.model.*;
import com.web.boot.gurupetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private  final PetTypeService petTypeService;
    private  final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty saveRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty saveSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty saveDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded specialities");

        Owner owner1 = new Owner();
        owner1.setFirstName("Arron");
        owner1.setLastName("Arnold");
        owner1.setAddress("Flat A Amber stree");
        owner1.setCity("Andromida");
        owner1.setTelephone("11111111");

        Owner owner2 = new Owner();
        owner2.setFirstName("Ben");
        owner2.setLastName("Brunswic");
        owner2.setAddress("Flat 2B berry road");
        owner2.setCity("Belladona");
        owner2.setTelephone("22222222");

        Pet arnoldsPet = new Pet();
        arnoldsPet.setName("Art");
        arnoldsPet.setPetType(savedDogType);
        arnoldsPet.setBirthDate(LocalDate.now());
        arnoldsPet.setOwner(owner1);
        owner1.getPets().add(arnoldsPet);

        Pet bensPet = new Pet();
        bensPet.setName("Bart");
        bensPet.setPetType(savedCatType);
        bensPet.setBirthDate(LocalDate.now());
        bensPet.setOwner(owner2);
        owner2.getPets().add(bensPet);

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Carol");
        vet1.setLastName("Carlson");
        vet1.getSpecialties().add(radiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Deen");
        vet2.setLastName("Deans");
        vet2.getSpecialties().add(surgery);

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets");

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Spading");
        catVisit.setPet(bensPet);

        visitService.save(catVisit);
        System.out.println("Loaded Visits");
    }
}
