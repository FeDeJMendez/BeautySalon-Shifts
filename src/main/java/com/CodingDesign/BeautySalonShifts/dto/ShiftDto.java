package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.model.Client;
import com.CodingDesign.BeautySalonShifts.model.Employee;
import com.CodingDesign.BeautySalonShifts.model.Shift;
import com.CodingDesign.BeautySalonShifts.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShiftDto {
    private Integer id;
    private ClientDto client;
    private EmployeeDto employee;

    public static ShiftDto from (Shift shift) {
        Client client = shift.getClient();
        Employee employee = shift.getEmployee();
        Specialty specialty = employee.getSpecialty();
        return ShiftDto.builder()
                .id(shift.getId())
                .client(ClientDto.builder()
                        .id(client.getId())
                        .name(client.getName())
                        .lastname(client.getLastname())
                        .dni(client.getDni())
                        .build())
                .employee(EmployeeDto
                        .builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .lastname(employee.getLastname())
                        .dni(employee.getDni())
                        .specialty(SpecialtyDto
                                .builder()
                                .id(specialty.getId())
                                .detail(specialty.getDetail())
                                .amount(specialty.getAmount())
                                .build())
                        .build())
                .build();
    }
}
