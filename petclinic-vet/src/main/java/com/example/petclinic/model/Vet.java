package com.example.petclinic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name= "Vet")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ElementCollection
    private List<Speciality> specialities = new ArrayList<>();
    @ElementCollection
    private List<Long> visitIds = new ArrayList<>();

    protected Vet() {

    }

    public Vet(String name, List<Speciality> specialities) {
        this.name = name;
        this.specialities = specialities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void addSpeciality(Speciality speciality) {
        this.specialities.add(speciality);
    }

    public void addVisitId(Long visitId) {
        this.visitIds.add(visitId);
    }

    public void removeVisitId(Long visitId) {
        this.visitIds.remove(visitId);
    }

    public List<Long> getVisits() {
        return this.visitIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vet vet = (Vet) o;
        return Objects.equals(id, vet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vet{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        //sb.append(", specialities=").append(specialities);
        sb.append('}');
        return sb.toString();
    }

    public static VetBuilder builder() {
        return new VetBuilder();
    }

    public static final class VetBuilder {

        private Vet vet;

        private VetBuilder() {
            vet = new Vet();
        }

        public VetBuilder withName(String name) {
            vet.setName(name);
            return this;
        }

        public VetBuilder withSpeciality(Speciality speciality) {
            vet.addSpeciality(speciality);
            return this;
        }

        public VetBuilder withVisitId(Long visitId) {
            vet.addVisitId(visitId);
            return this;
        }

        public Vet build() {
            return vet;
        }
    }
}
