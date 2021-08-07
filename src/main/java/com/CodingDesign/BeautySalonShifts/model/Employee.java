package com.CodingDesign.BeautySalonShifts.model;

import com.CodingDesign.BeautySalonShifts.interfaces.URIinterface;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "employees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Employee extends Person implements URIinterface {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specialty")
    @Builder.Default
    private Specialty specialty = null;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Shift> shifts;
}
