package org.springframework.samples.petclinic.Invitacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;

@DataJpaTest
public class InvitacionServiceTest {
    
    @Autowired
    InvitationRepository invitationRepository;

    @Autowired
    UserRepository userRepository;



    @Test
    public void getInvitationsOfTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);
        List<Invitation> invitaciones = invitationService.getInvitationsOf("ignwarmur");
        assertNotNull(invitaciones);
        assertFalse(invitaciones.isEmpty());
        assertEquals(1, invitaciones.size());
    }



    
    @Test
    public void sendInvitationSuccessfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);
        String username1 = "Manpalpin02";
        String username2 = "pabmarval";

        try{
            invitationService.sendInvitation(username1, username2);
        } catch(Exception e){
            fail("Esta excepcion no deberia salir");
        }
    }

    @Test
    public void sendInvitationUnsuccesfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);
        String username1 = "prueba1";
        String username2 = "prueba2";

        assertThrows(Exception.class, () -> invitationService.sendInvitation(username1, username2));
    }



    @Test
    public void acceptInvitationSuccessfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);
        String username = "ignwarmur";

        try{
            invitationService.acceptInvitation(username, 1);
        } catch(Exception e){
            fail("Esta escepcion no deberia salir");
        }
    }

    @Test
    public void acceptInvitationUnsuccessfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);
        String username = "prueba";

        assertThrows(Exception.class, () -> invitationService.acceptInvitation(username, 143));
    }



    @Test
    public void deleteInvitationByIdSuccessfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);

        try{
            invitationService.deleteInvitationById(1);
        } catch(Exception e){
            fail("Esta escepcion no deberia salir");
        }
    }

    @Test
    public void deleteInvitationByIdUnsuccessfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);

        assertThrows(Exception.class, () -> invitationService.deleteInvitationById(345658678));
    }



    @Test
    public void getAvailableUsersSuccessfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);
        List<User> usuarios = invitationService.getAvailableUsers("Manpalpin02");
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertEquals(6, usuarios.size());
    }

    @Test
    public void getAvailableUsersUnsuccessfulTest(){
        InvitationService invitationService = new InvitationService(invitationRepository, userRepository);
        assertThrows(Exception.class, () -> invitationService.getAvailableUsers("prueba"));
    }
}
