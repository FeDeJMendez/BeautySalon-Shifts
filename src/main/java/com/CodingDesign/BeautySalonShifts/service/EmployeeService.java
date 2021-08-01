package com.CodingDesign.BeautySalonShifts.service;

import com.CodingDesign.BeautySalonShifts.exceptions.EmployeeExistsException;
import com.CodingDesign.BeautySalonShifts.exceptions.EmployeeNotExistsException;
import com.CodingDesign.BeautySalonShifts.model.Employee;
import com.CodingDesign.BeautySalonShifts.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee addEmployee(Employee employee)
            throws EmployeeExistsException {
        if (employeeRepository.existsByDni(employee.getDni()))
            throw new EmployeeExistsException();
        return employeeRepository.save(employee);
    }

    public Page getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee getById (Integer id)
            throws EmployeeNotExistsException {
        return employeeRepository.findById(id)
                .orElseThrow(EmployeeNotExistsException::new);
    }

    public void deleteById(Integer id)
            throws EmployeeNotExistsException{
        if (employeeRepository.existsById(id))
            employeeRepository.deleteById(id);
        else throw new EmployeeNotExistsException();
    }
}
