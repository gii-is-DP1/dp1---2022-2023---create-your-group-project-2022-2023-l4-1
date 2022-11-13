package org.springframework.samples.petclinic.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends  CrudRepository<User, String>{

    List<User> findAll();
	
}
