package org.springframework.samples.petclinic.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.samples.petclinic.user.UserService;

@DataJpaTest
public class UserServiceTest {
    
    @Autowired
    UserRepository userRepository;



    @Test
    public void findUserSuccessfulTest(){
        UserService userService = new UserService(userRepository);

        User user = userService.findUser("Manpalpin02").get();

        assertNotNull(user);
        assertEquals("Manpalpin02", user.getPassword());
        assertEquals("Palacios Pineda", user.getApellidos());
    }

    @Test
    public void findUserUnsuccessfulTest(){
        UserService userService = new UserService(userRepository);

        assertThrows(Exception.class, () -> userService.findUser("prueba").get());
    }



    @Test
    public void findUserByUsernameSuccessfulTest(){
        UserService userService = new UserService(userRepository);

        Collection<User> usuarios = userService.findUserByUsername("pab");

        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertEquals(1, usuarios.size());
    }

    @Test
    public void findUserByUsernameUnsuccessfulTest(){
        UserService userService = new UserService(userRepository);

        Collection<User> usuarios = userService.findUserByUsername("wds");

        assertNotNull(usuarios);
        assertTrue(usuarios.isEmpty());
    }



    @Test
    public void getUsuariosSuccessfulTest(){
        UserService userService = new UserService(userRepository);

        List<User> usuarios = userService.getUsuarios();

        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertEquals(7, usuarios.size());
    }



    @Test
    public void deleteUserByIdSuccessfulTest(){
        UserService userService = new UserService(userRepository);

        try{
            userService.deleteUserById("Manpalpin02");
        } catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void deleteUserByIdUnsuccessfulTest(){
        UserService userService = new UserService(userRepository);

        assertThrows(Exception.class, () -> userService.deleteUserById("sgrthrt"));
    }



    @Test
    public void getFriendsSuccessfulTest(){
        UserService userService = new UserService(userRepository);

        List<User> amigos = userService.getFriends("davcorrom");

        assertNotNull(amigos);
        assertFalse(amigos.isEmpty());
        assertEquals(1, amigos.size());
    }

    @Test
    public void getFriendsUnsccessfulTest(){
        UserService userService = new UserService(userRepository);

        List<User> amigos = userService.getFriends("wrsh");

        assertNotNull(amigos);
        assertTrue(amigos.isEmpty());
    }



    @Test
    public void deleteFriendSuccessfulTest(){
        UserService userService = new UserService(userRepository);

        try{
            userService.Deletefriend("davcorrom", "ignwarmun");
        } catch(Exception e){
            fail(e);
        }
    }
}
