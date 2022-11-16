package org.springframework.samples.petclinic.user;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends  CrudRepository<User, String>{

    List<User> findAll();

    @Query("SELECT user FROM User user WHERE user.username LIKE :username")
	public Optional<User> findByUsername(@Param("username") String username);
	
    @Query("SELECT DISTINCT user FROM User user WHERE user.nombre LIKE :nombre%")
	public Collection<User> findByName(@Param("nombre") String nombre);


}
