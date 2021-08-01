package com.CodingDesign.BeautySalonShifts.controller;

import com.CodingDesign.BeautySalonShifts.config.Conf;
import com.CodingDesign.BeautySalonShifts.dto.EmployeeDto;
import com.CodingDesign.BeautySalonShifts.exceptions.EmployeeExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.EmployeeNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Employee;
import com.CodingDesign.BeautySalonShifts.service.EmployeeService;
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
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    /// ADD NEW ///
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addEmployee (@RequestBody EmployeeDto employeeDto)
            throws EmployeeExistsException {
        Employee newEmployee = employeeService.addEmployee(modelMapper.map(employeeDto, Employee.class));
        return ResponseEntity.created(Conf.getLocation(newEmployee)).build();
    }

    /// GET ALL ///
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAll(Pageable pageable) {
        Page page = employeeService.getAll(pageable);
        return ResponseEntity
                .status(page.getTotalElements() != 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .header("Total-Elements", Long.toString(page.getTotalElements()))
                .header("Total-Pages", Long.toString(page.getTotalPages()))
                .body(page.getContent());
    }

    /// GET BY ID ///
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getById (@PathVariable Integer id)
            throws EmployeeNotExistsException{
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(EmployeeDto.from(employee));
    }

    /// DELETE BY ID ///
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteEmployee (@PathVariable Integer id)
            throws EmployeeNotExistsException {
        employeeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
