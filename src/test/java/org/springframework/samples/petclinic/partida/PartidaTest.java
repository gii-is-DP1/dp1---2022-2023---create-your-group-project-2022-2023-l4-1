package org.springframework.samples.petclinic.partida;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.user.User;

public class PartidaTest {
    
    @Test
    public void getUsersOnTheGameSuccessfulTest(){
        Partida partida = new Partida();
        User user0 = new User();
        User user1 = new User();
        User user2 = new User();
        partida.setUser0(user0);
        partida.setUser1(user1);
        partida.setUser2(user2);
        List<User> users = List.of(user0, user1, user2);

        boolean actualResult = partida.getUsersOnTheGame().equals(users);

        assertTrue(actualResult);
    }

    @Test
    public void getUsersOnTheGameUnsuccessfulTest(){
        Partida partida = new Partida();
        User user0 = new User();
        User user1 = new User();
        User user2 = new User();
        partida.setUser0(user0);
        partida.setUser1(user1);
        partida.setUser2(user2);
        User user3 = new User();
        List<User> users = List.of(user0, user1, user3);

        boolean actualResult = partida.getUsersOnTheGame().equals(users);

        assertFalse(actualResult);
    }
}
