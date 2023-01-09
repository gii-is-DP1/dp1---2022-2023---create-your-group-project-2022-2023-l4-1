package org.springframework.samples.petclinic.tablero;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableroRepository extends CrudRepository<Tablero, Integer> {

    List<Tablero> findAll();
    
}
