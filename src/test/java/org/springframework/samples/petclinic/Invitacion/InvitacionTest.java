package org.springframework.samples.petclinic.Invitacion;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.user.User;

public class InvitacionTest {
    
    @Test
    public void esDelUsuarioSuccessTest(){
        Invitation invitacion = new Invitation();
        User user1 = new User();
        user1.setUsername("Prueba1");
        User user2 = new User();
        user2.setUsername("Prueba2");

        invitacion.setReceiver(user1);
        invitacion.setSender(user2);

        boolean actualResult = true == invitacion.correspondencia("Prueba1");

        assertTrue(actualResult);
    }

    @Test
    public void esDelUsuarioUnSuccessTest(){
        Invitation invitacion = new Invitation();
        User user1 = new User();
        user1.setUsername("Prueba1");
        User user2 = new User();
        user2.setUsername("Prueba2");

        invitacion.setReceiver(user1);
        invitacion.setSender(user2);

        boolean actualResult = false == invitacion.correspondencia("NoExiste");

        assertTrue(actualResult);
    }
}
