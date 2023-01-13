package org.springframework.samples.petclinic.objetos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoRepository extends CrudRepository<Objeto,Integer> {

    List<Objeto> findAll();
    
}
