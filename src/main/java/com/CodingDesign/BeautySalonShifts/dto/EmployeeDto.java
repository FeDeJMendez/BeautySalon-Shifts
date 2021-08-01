package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.model.Employee;
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
    private Integer nroEmpleado;

    public static EmployeeDto from(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastname(employee.getLastname())
                .dni(employee.getDni())
                .nroEmpleado(employee.getNroEmpleado())
                .build();
    }
}
