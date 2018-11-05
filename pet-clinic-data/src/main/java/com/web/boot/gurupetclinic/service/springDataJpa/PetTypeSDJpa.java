package com.web.boot.gurupetclinic.service.springDataJpa;

import com.web.boot.gurupetclinic.model.PetType;
import com.web.boot.gurupetclinic.repositories.PetTypeRepository;
import com.web.boot.gurupetclinic.service.PetTypeService;

import java.util.HashSet;
import java.util.Set;

public class PetTypeSDJpa implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {

        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
