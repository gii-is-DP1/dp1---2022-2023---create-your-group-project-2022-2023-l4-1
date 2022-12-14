package org.springframework.samples.petclinic.Invitacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class InvitacionRepositoryTest {
    
    @Autowired
    InvitationRepository invitationRepository;

    @Test
    public void getInvitationsOfSuccessTest(){
        List<Invitation> invitaciones = invitationRepository.getInvitationsOf("ignwarmur");
        assertNotNull(invitaciones);
        assertFalse(invitaciones.isEmpty());
        assertEquals(1, invitaciones.size());
    }

    @Test
    public void getInvitationsOfUnSuccessTest(){
        List<Invitation> invitaciones = invitationRepository.getInvitationsOf("Manpalpin02");
        assertNotNull(invitaciones);
        assertTrue(invitaciones.isEmpty());
    }
}
