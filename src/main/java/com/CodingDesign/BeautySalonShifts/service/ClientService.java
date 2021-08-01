package com.CodingDesign.BeautySalonShifts.service;

import com.CodingDesign.BeautySalonShifts.exceptions.ClientExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.ClientNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Client;
import com.CodingDesign.BeautySalonShifts.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public Client addClient(Client client)
            throws ClientExistsException{
        if (clientRepository.existsByDni(client.getDni()))
            throw new ClientExistsException();
        return clientRepository.save(client);
    }

    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client getById(Integer id)
            throws ClientNotExistsException {
        return clientRepository.findById(id)
                .orElseThrow(ClientNotExistsException::new);
    }

    public void deleteById(Integer id)
            throws ClientNotExistsException {
        if (clientRepository.existsById(id))
            clientRepository.deleteById(id);
        else throw new ClientNotExistsException();
    }

}
