package com.CodingDesign.BeautySalonShifts.repository;

import com.CodingDesign.BeautySalonShifts.model.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository <Specialty, Integer> {

    Page findAll(Pageable pageable);
}
