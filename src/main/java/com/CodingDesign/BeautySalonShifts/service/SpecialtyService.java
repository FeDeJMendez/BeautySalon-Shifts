package com.CodingDesign.BeautySalonShifts.service;

import com.CodingDesign.BeautySalonShifts.exceptions.SpecialtyNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Specialty;
import com.CodingDesign.BeautySalonShifts.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public Specialty addNew(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Page getAll(Pageable pageable) {
        return specialtyRepository.findAll(pageable);
    }

    public Specialty getById(Integer id)
            throws SpecialtyNotExistsException{
        return specialtyRepository.findById(id)
                .orElseThrow(SpecialtyNotExistsException::new);
    }

    public void deleteById(Integer id)
            throws SpecialtyNotExistsException{
        if (specialtyRepository.existsById(id))
            specialtyRepository.deleteById(id);
        else throw new SpecialtyNotExistsException();
    }
}
