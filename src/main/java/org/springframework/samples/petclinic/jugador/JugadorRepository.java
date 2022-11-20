package org.springframework.samples.petclinic.jugador;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface JugadorRepository extends CrudRepository<Jugador, Integer>{

	<S extends Jugador> S save(Jugador jugador) throws DataAccessException;
    
	@Query("SELECT DISTINCT jugador FROM Jugador jugador WHERE jugador.user.apellidos LIKE :lastName%")
	public Collection<Jugador> findByLastName(@Param("lastName") String lastName);

	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.id =:id")
	public Jugador findById(@Param("id") int id);
	
	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.user.username =:username")
	public Jugador findByUsername(@Param("username") String username);
}

