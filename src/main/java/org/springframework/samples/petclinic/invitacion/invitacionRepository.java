package org.springframework.samples.petclinic.invitacion;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface invitacionRepository extends CrudRepository<invitacion, Integer> {
    
    @Query("SELECT i FROM Invitation i WHERE i.receiver.username = ?1")
	List<invitacion> getInvitationsOf(String username);
}