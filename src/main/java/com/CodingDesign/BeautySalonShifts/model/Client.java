package com.CodingDesign.BeautySalonShifts.model;

import com.CodingDesign.BeautySalonShifts.interfaces.URIinterface;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "clients")
@Entity
public class Client extends Person implements URIinterface {
    @Column
    private Integer nroCliente;

/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Shift> shifts;*/
}
