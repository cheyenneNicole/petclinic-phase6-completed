package com.example.petclinic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Visit {

    private Long id;

    private Date dateOfVisit;
    private String description;
    private Long petId;

    private List<Long> vetIds = new ArrayList<>();

    protected Visit() {

    }

    public Visit(Date dateOfVisit, String description) {
        this.dateOfVisit = dateOfVisit;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public void addVet(Long vetId) {
        this.vetIds.add(vetId);
    }

    public void removeVet(Long vetId) {
        this.vetIds.remove(vetId);
    }

    public List<Long> getVets() {
        return this.vetIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visit{");
        sb.append("id=").append(id);
        sb.append(", dateOfVisit=").append(dateOfVisit);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static VisitBuilder builder() {
        return new VisitBuilder();
    }

    public static final class VisitBuilder {

        private Visit visit;

        private VisitBuilder() {
            visit = new Visit();
        }

        public VisitBuilder withDateOfVisit(Date dateOfVisit) {
            visit.setDateOfVisit(dateOfVisit);
            return this;
        }

        public VisitBuilder withDescription(String description) {
            visit.setDescription(description);
            return this;
        }

        public VisitBuilder withPetId(Long petId) {
            visit.setPetId(petId);
            return this;
        }

        public VisitBuilder withVetId(Long vetId) {
            visit.addVet(vetId);
            return this;
        }

        public Visit build() {
            return visit;
        }
    }
}
