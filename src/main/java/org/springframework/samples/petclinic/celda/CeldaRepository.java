package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CeldaRepository extends CrudRepository<Celda, Integer> {

    List<Celda> findAll();

    @Query("SELECT celda FROM Celda celda WHERE celda.id =:id")
	public Celda findById(@Param("id") int id);
    
}
