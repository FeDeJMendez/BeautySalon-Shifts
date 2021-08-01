package com.CodingDesign.BeautySalonShifts.repository;

import com.CodingDesign.BeautySalonShifts.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Page findAll(Pageable pageable);

    boolean existsByDni(Integer dni);
}
