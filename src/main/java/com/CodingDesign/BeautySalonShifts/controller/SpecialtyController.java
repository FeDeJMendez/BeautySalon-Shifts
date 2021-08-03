package com.CodingDesign.BeautySalonShifts.controller;

import com.CodingDesign.BeautySalonShifts.config.Conf;
import com.CodingDesign.BeautySalonShifts.dto.SpecialtyDto;
import com.CodingDesign.BeautySalonShifts.exceptions.SpecialtyNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Specialty;
import com.CodingDesign.BeautySalonShifts.service.SpecialtyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {

    private final SpecialtyService specialtyService;
    private final ModelMapper modelMapper;

    @Autowired
    public SpecialtyController(SpecialtyService specialtyService, ModelMapper modelMapper) {
        this.specialtyService = specialtyService;
        this.modelMapper = modelMapper;
    }


    /// ADD NEW ///
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSpecialty (@RequestBody SpecialtyDto specialtyDto) {
        Specialty newSpecialty = specialtyService.addNew(modelMapper.map(specialtyDto, Specialty.class));
        return ResponseEntity.created(Conf.getLocation(newSpecialty)).build();
    }

    /// GET ALL ///
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Specialty>> getAll (Pageable pageable) {
        Page page = specialtyService.getAll(pageable);
        return ResponseEntity
                .status(page.getSize() != 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .header("Total-Elements", Long.toString(page.getTotalElements()))
                .header("Total-Pages", Long.toString(page.getTotalPages()))
                .body(page.getContent());
    }

    /// GET BY ID ///
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpecialtyDto> getById (@PathVariable Integer id)
            throws SpecialtyNotExistsException {
        Specialty specialty = specialtyService.getById(id);
        return ResponseEntity.ok(SpecialtyDto.from(specialty));
    }

    /// DELETE BY ID ///
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSpecialty (@PathVariable Integer id)
            throws SpecialtyNotExistsException{
        specialtyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
