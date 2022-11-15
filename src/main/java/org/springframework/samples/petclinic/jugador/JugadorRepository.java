package org.springframework.samples.petclinic.jugador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Integer>{
    
	@Query("SELECT DISTINCT jugador FROM Jugador jugador WHERE jugador.user.apellidos LIKE :lastName%")
	public Collection<Jugador> findByLastName(@Param("lastName") String lastName);

	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.id =:id")
	public Jugador findById(@Param("id") int id);
	
	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.user.username =:username")
	public Jugador findByUsername(@Param("username") String username);
}

