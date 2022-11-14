package org.springframework.samples.petclinic.jugador;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Integer> {
    
    List<Jugador> findAll();

    @Query("SELECT jugador FROM Jugador jugador WHERE jugador.usuario.username =:username")
	public Jugador findByUsername(@Param("username") String username);
}
