package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.model.Client;
import com.CodingDesign.BeautySalonShifts.model.Employee;
import com.CodingDesign.BeautySalonShifts.model.Shift;
import com.CodingDesign.BeautySalonShifts.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EmployeeDto extends PersonDto {
    private SpecialtyDto specialty;
    private List<ShiftDto> shifts;

    public static EmployeeDto from(Employee employee){
        Specialty specialty = employee.getSpecialty();
        List<Shift> shifts = employee.getShifts();
        List<ShiftDto> shiftDtos = Collections.emptyList();
        if (shifts.size() != 0 && shifts != null)
            shiftDtos = shifts.stream()
                    .map(s -> ShiftDto.builder()
                            .id(s.getId())
                            .client(ClientDto.builder()
                                    .id(s.getClient().getId())
                                    .name(s.getClient().getName())
                                    .lastname(s.getClient().getLastname())
                                    .dni(s.getClient().getDni())
                                    .build())
                            .build())
                    .collect(Collectors.toList());
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
                .shifts(shiftDtos)
                .build();
    }
}
