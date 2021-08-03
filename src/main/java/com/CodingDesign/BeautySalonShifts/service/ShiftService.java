package com.CodingDesign.BeautySalonShifts.service;

import com.CodingDesign.BeautySalonShifts.exceptions.ClientNotExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.ShiftNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Shift;
import com.CodingDesign.BeautySalonShifts.repository.ClientRepository;
import com.CodingDesign.BeautySalonShifts.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository, ClientRepository clientRepository) {
        this.shiftRepository = shiftRepository;
        this.clientRepository = clientRepository;
    }

    public Shift addShift(Shift shift)
            throws ClientNotExistsException {
        if (clientRepository.existsById(shift.getClient().getId()))
            return shiftRepository.save(shift);
        else throw new ClientNotExistsException();
    }

    public Page getAll(Pageable pageable) {
        return shiftRepository.findAll(pageable);
    }

    public Shift getById(Integer id)
            throws ShiftNotExistsException{
        return shiftRepository.findById(id)
                .orElseThrow(ShiftNotExistsException::new);
    }

    public void deleteById(Integer id)
            throws ShiftNotExistsException {
        shiftRepository.deleteById(id);
    }
}
