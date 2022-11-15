package org.springframework.samples.petclinic.user;

import org.springframework.data.repository.CrudRepository;



public interface AuthoritiesRepository extends  CrudRepository<Authorities, String>{

    Authorities findByUser(String username);
	
}
