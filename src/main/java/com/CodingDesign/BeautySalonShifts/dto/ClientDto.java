package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.model.Client;
import com.CodingDesign.BeautySalonShifts.model.Shift;
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
public class ClientDto extends PersonDto{
    private List<ShiftDto> shifts;

    public static ClientDto from (Client client){
        List<Shift> shifts = client.getShifts();
        List<ShiftDto> shiftDtos = Collections.emptyList();
        if (shifts != null){
            shiftDtos = shifts.stream()
                    .map(x -> ShiftDto.builder()
                            .id(x.getId())
                            .build())
                    .collect(Collectors.toList());
        }
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .lastname(client.getLastname())
                .dni(client.getDni())
                .shifts(shiftDtos)
                .build();
    }

}
