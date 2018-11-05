package com.web.boot.gurupetclinic.service.springDataJpa;

import com.web.boot.gurupetclinic.model.Vet;
import com.web.boot.gurupetclinic.repositories.SpecialtyRepository;
import com.web.boot.gurupetclinic.repositories.VetRepository;
import com.web.boot.gurupetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")

public class VetSDJpa implements VetService {

    private final VetRepository vetRepository;
    private final SpecialtyRepository specialtyRepository;

    public VetSDJpa(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vetSet = new HashSet<>();
        vetRepository.findAll().forEach(vetSet::add);
        return vetSet;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
