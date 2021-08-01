package com.CodingDesign.BeautySalonShifts.model;

import com.CodingDesign.BeautySalonShifts.interfaces.URIinterface;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "employees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Employee extends Person implements URIinterface {
    @Column
    private Integer nroEmpleado;

    /*@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provision", nullable = false)
    private Provision provision;*/

}
