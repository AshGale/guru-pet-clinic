package com.web.boot.gurupetclinic.bootstrap;

import com.web.boot.gurupetclinic.model.Owner;
import com.web.boot.gurupetclinic.model.Vet;
import com.web.boot.gurupetclinic.service.OwnerService;
import com.web.boot.gurupetclinic.service.VetService;
import com.web.boot.gurupetclinic.service.map.OwnerServiceMap;
import com.web.boot.gurupetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Arron");
        owner1.setLastName("Arnold");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ben");
        owner2.setLastName("Brunswic");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Carol");
        vet1.setLastName("Carlson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Deen");
        vet2.setLastName("Deans");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
