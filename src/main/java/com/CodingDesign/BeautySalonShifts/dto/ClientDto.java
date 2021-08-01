package com.CodingDesign.BeautySalonShifts.dto;

import com.CodingDesign.BeautySalonShifts.model.Client;
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
public class ClientDto extends PersonDto{
    private Integer nroCliente;

    public static ClientDto from (Client client){
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .lastname(client.getLastname())
                .dni(client.getDni())
                .nroCliente(client.getNroCliente())
                .build();
    }


}
