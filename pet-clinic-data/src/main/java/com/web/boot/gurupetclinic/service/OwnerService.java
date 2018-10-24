package com.web.boot.gurupetclinic.service;

import com.web.boot.gurupetclinic.model.Owner;

public interface OwnerService extends CrudService <Owner, Long>{

    Owner findByLastName(String lastName);
}
