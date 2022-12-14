package org.springframework.samples.petclinic.partida;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface PartidaRepository extends CrudRepository<Partida, Integer> {

    List<Partida> findAll();

    @Query("SELECT partida FROM Partida partida WHERE partida.id =:id")
	public Partida findById(@Param("id") int id);
    

}