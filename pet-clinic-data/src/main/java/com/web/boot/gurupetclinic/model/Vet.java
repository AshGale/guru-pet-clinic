package com.web.boot.gurupetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

//    @Builder
//    public Vet(Long id, String firstName, String lastName, Set<Specialty> specialties) {
//        super(id, firstName, lastName);
//        this.specialties = specialties;
//    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
        joinColumns = @JoinColumn(name = "vet_id"),
        inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Specialty> specialties = new HashSet<>();
}
