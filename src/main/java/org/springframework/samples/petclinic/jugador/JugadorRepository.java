package org.springframework.samples.petclinic.jugador;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.samples.petclinic.partida.Partida;


public interface JugadorRepository extends CrudRepository<Jugador, Integer> {

	List<Jugador> findAll();
    
	@Query("SELECT DISTINCT jugador FROM Jugador jugador WHERE jugador.user.apellidos LIKE :lastName%")
	public Collection<Jugador> findByLastName(@Param("lastName") String lastName);

	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.id =:id")
	public Jugador findById(@Param("id") int id);
	
	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.user.username =:username")
	public Collection<Jugador> findByUsername(@Param("username") String username);

	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.user.username =:username AND jugador.partida =:partida")
	public Jugador findJugadorInAGame(@Param("username") String username, @Param("partida") Partida Partida);

}

