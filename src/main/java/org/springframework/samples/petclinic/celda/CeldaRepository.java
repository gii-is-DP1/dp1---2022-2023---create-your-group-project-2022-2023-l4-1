package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CeldaRepository extends CrudRepository<Celda, Integer> {

    List<Celda> findAll();
    
}
