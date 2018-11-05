package com.web.boot.gurupetclinic.repositories;

import com.web.boot.gurupetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {


}
