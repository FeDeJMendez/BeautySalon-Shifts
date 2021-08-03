package com.CodingDesign.BeautySalonShifts.controller;

import com.CodingDesign.BeautySalonShifts.config.Conf;
import com.CodingDesign.BeautySalonShifts.dto.ShiftDto;
import com.CodingDesign.BeautySalonShifts.exceptions.ClientNotExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.ShiftNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Shift;
import com.CodingDesign.BeautySalonShifts.service.ShiftService;
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
@RequestMapping("/api/shifts")
public class ShiftController {

    private final ShiftService shiftService;
    private final ModelMapper modelMapper;

    @Autowired
    public ShiftController(ShiftService shiftService, ModelMapper modelMapper) {
        this.shiftService = shiftService;
        this.modelMapper = modelMapper;
    }


    /// ADD NEW ///
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addShift (@RequestBody ShiftDto shiftDto)
            throws ClientNotExistsException {
        Shift newShift = shiftService.addShift(modelMapper.map(shiftDto, Shift.class));
        return ResponseEntity.created(Conf.getLocation(newShift)).build();
    }

    /// GET ALL ///
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShiftDto>> getAll (Pageable pageable) {
        Page page = shiftService.getAll(pageable);
        return ResponseEntity
                .status(page.getSize() != 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .header("Total-Elements", Long.toString(page.getTotalElements()))
                .header("Total-Pages", Long.toString(page.getTotalPages()))
                .body(page.getContent());
    }

    /// GET BY ID ///
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShiftDto> getByID (@PathVariable Integer id)
            throws ShiftNotExistsException {
        Shift shift = shiftService.getById(id);
        return ResponseEntity.ok(ShiftDto.from(shift));
    }

    /// DELETE BY ID ///
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteShift (@PathVariable Integer id)
            throws ShiftNotExistsException {
        shiftService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
