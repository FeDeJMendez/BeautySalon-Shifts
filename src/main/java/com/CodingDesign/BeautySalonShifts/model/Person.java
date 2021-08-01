package com.CodingDesign.BeautySalonShifts.model;

import com.CodingDesign.BeautySalonShifts.interfaces.URIinterface;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "persons")
public abstract class Person implements URIinterface{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column(unique = true)
    private Integer dni;
}
