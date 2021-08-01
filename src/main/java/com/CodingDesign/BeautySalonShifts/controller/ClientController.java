package com.CodingDesign.BeautySalonShifts.controller;

import com.CodingDesign.BeautySalonShifts.config.Conf;
import com.CodingDesign.BeautySalonShifts.dto.ClientDto;
import com.CodingDesign.BeautySalonShifts.exceptions.ClientExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.ClientNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Client;
import com.CodingDesign.BeautySalonShifts.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }


    /// ADD NEW ///
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addClient (@RequestBody ClientDto clientDto)
            throws ClientExistsException {
        Client newClient = clientService.addClient(modelMapper.map(clientDto, Client.class));
        return ResponseEntity.created(Conf.getLocation(newClient)).build();
    }

    /// GET ALL ///
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDto>> getAll (Pageable pageable) {
        Page page =clientService.getAll(pageable);
        return ResponseEntity
                .status(page.getTotalElements() != 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .header("Total-Elements", Long.toString(page.getTotalElements()))
                .header("Total-Pages", Long.toString(page.getTotalPages()))
                .body(page.getContent());
    }

    /// GET BY ID ///
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> getById (@PathVariable Integer id) throws ClientNotExistsException{
        Client client = clientService.getById(id);
        return ResponseEntity.ok(ClientDto.from(client));
    }

    /// DELETE BY ID ///
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteClient (@PathVariable Integer id)
            throws ClientNotExistsException {
        clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
