package org.springframework.samples.petclinic.partida;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PartidaRepository extends CrudRepository<Partida, Integer> {

    List<Partida> findAll();
    
}
