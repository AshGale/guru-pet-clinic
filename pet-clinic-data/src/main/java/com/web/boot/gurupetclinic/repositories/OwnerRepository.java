package com.web.boot.gurupetclinic.repositories;

import com.web.boot.gurupetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastname);

}
