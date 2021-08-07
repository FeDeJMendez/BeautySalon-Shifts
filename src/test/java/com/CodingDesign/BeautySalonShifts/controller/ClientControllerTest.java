package com.CodingDesign.BeautySalonShifts.controller;

import com.CodingDesign.BeautySalonShifts.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

public class ClientControllerTest {

    @Mock
    private ClientService clientService;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ClientController clientController;

    /*private ClientService clientService;
    private ModelMapper modelMapper;

    @Before
    public void SetUp(){
        this.clientService = mock(ClientService.class);
        this.modelMapper = mock(ModelMapper.class);
        ClientController clientController = new ClientController(clientService, modelMapper);
    }*/

    @Test
    public void TestGetByIdOk () {

    }
}
