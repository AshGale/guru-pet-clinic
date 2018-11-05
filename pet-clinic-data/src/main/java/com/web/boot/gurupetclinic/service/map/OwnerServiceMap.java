package com.web.boot.gurupetclinic.service.map;

import com.web.boot.gurupetclinic.model.Owner;
import com.web.boot.gurupetclinic.model.Pet;
import com.web.boot.gurupetclinic.service.OwnerService;
import com.web.boot.gurupetclinic.service.PetService;
import com.web.boot.gurupetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

    private PetService petService;
    private PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null){

            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    //ensure petType has id
                    if (pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw  new  RuntimeException(" Pet Type is required");
                    }
                    //Ensure pet had id
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });
            }

            return super.save(object);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
