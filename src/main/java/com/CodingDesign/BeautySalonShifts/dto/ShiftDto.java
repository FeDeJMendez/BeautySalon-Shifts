package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.model.Client;
import com.CodingDesign.BeautySalonShifts.model.Shift;
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

    public static ShiftDto from (Shift shift) {
        Client client = shift.getClient();
        return ShiftDto.builder()
                .id(shift.getId())
                .client(ClientDto.builder()
                        .id(client.getId())
                        .name(client.getName())
                        .lastname(client.getLastname())
                        .dni(client.getDni())
                        .build())
                .build();
    }
}
