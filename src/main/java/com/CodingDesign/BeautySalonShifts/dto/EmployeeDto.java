package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.model.Employee;
import com.CodingDesign.BeautySalonShifts.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EmployeeDto extends PersonDto {
    private SpecialtyDto specialty;

    public static EmployeeDto from(Employee employee){
        Specialty specialty = employee.getSpecialty();
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastname(employee.getLastname())
                .dni(employee.getDni())
//                .specialty(SpecialtyDto.from(employee.getSpecialty()))
                .specialty(SpecialtyDto.builder()
                        .id(specialty.getId())
                        .detail(specialty.getDetail())
                        .amount(specialty.getAmount())
                        .build())
                .build();
    }
}
