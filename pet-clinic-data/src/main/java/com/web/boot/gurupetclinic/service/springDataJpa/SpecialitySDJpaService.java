package com.web.boot.gurupetclinic.service.springDataJpa;

import com.web.boot.gurupetclinic.model.Specialty;
import com.web.boot.gurupetclinic.repositories.SpecialtyRepository;
import com.web.boot.gurupetclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class SpecialitySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialtySet = new HashSet<>();
        specialtyRepository.findAll().forEach(specialtySet::add);
        return specialtySet;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
