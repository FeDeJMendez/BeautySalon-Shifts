package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.interfaces.URIinterface;
import com.CodingDesign.BeautySalonShifts.model.Employee;
import com.CodingDesign.BeautySalonShifts.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialtyDto {
    private Integer id;
    private String detail;
    private Double amount;
    private List<EmployeeDto> employees;

    public static SpecialtyDto from(Specialty specialty) {
        List<Employee> employees = specialty.getEmployees();
        List<EmployeeDto> employeeDtos = Collections.EMPTY_LIST;
        if (employees != null) {
//            employeeDtos = employees.stream().map(x -> EmployeeDto.from(x)).collect(Collectors.toList());
            employeeDtos = employees.stream()
                    .map(x -> EmployeeDto.builder()
                            .id(x.getId())
                            .name(x.getName())
                            .lastname(x.getLastname())
                            .dni(x.getDni())
                            .build())
                    .collect(Collectors.toList());
        }
        return SpecialtyDto.builder()
                .id(specialty.getId())
                .detail(specialty.getDetail())
                .amount(specialty.getAmount())
                .employees(employeeDtos)
                .build();
    }
}
