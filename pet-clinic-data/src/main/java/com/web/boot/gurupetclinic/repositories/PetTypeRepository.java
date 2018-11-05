package com.web.boot.gurupetclinic.repositories;

import com.web.boot.gurupetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {


}
