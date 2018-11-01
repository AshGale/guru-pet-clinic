package com.web.boot.gurupetclinic.bootstrap;

import com.web.boot.gurupetclinic.model.Owner;
import com.web.boot.gurupetclinic.model.PetType;
import com.web.boot.gurupetclinic.model.Vet;
import com.web.boot.gurupetclinic.service.OwnerService;
import com.web.boot.gurupetclinic.service.PetTypeService;
import com.web.boot.gurupetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private  final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes");

        Owner owner1 = new Owner();
        owner1.setFirstName("Arron");
        owner1.setLastName("Arnold");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ben");
        owner2.setLastName("Brunswic");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Carol");
        vet1.setLastName("Carlson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Deen");
        vet2.setLastName("Deans");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
