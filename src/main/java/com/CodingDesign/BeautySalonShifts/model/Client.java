package com.CodingDesign.BeautySalonShifts.model;

import com.CodingDesign.BeautySalonShifts.interfaces.URIinterface;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "clients")
@Entity
public class Client extends Person implements URIinterface {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Shift> shifts;

}
