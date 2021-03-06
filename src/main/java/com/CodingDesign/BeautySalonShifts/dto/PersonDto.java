package com.CodingDesign.BeautySalonShifts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PersonDto {
    private Integer id;
    private String name;
    private String lastname;
    private Integer dni;
}
