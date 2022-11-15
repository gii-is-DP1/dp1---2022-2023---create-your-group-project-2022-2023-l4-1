package org.springframework.samples.petclinic.jugador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Integer>{
    

	/**
	 * Retrieve <code>Owner</code>s from the data store by last name, returning all owners
	 * whose last name <i>starts</i> with the given name.
	 * @param lastName Value to search for
	 * @return a <code>Collection</code> of matching <code>Owner</code>s (or an empty
	 * <code>Collection</code> if none found)
	 */	
	@Query("SELECT DISTINCT jugador FROM Jugador jugador WHERE jugador.user.apellido LIKE :lastName%")
	public Collection<Jugador> findByLastName(@Param("lastName") String lastName);


	/**
	 * Retrieve an <code>Owner</code> from the data store by id.
	 * @param id the id to search for
	 * @return the <code>Owner</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */	
	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.id =:id")
	public Jugador findById(@Param("id") int id);

	/**
	 * Retrieve an <code>Player</code> from the data store by username.
	 * @param username the username to search for
	 * @return the <code>Player </code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */	
	
	@Query("SELECT jugador FROM Jugador jugador WHERE jugador.user.username =:username")
	public Jugador findByUsername(@Param("username") String username);
}

