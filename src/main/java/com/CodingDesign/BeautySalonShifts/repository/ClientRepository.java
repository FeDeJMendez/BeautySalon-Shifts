package com.CodingDesign.BeautySalonShifts.repository;

import com.CodingDesign.BeautySalonShifts.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    Page<Client> findAll(Pageable pageable);

    boolean existsByDni(Integer dni);
}
