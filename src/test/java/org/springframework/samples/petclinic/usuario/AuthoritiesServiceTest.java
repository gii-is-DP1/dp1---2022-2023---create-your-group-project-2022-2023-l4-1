package org.springframework.samples.petclinic.usuario;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.user.Authorities;
import org.springframework.samples.petclinic.user.AuthoritiesRepository;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.samples.petclinic.user.UserService;

@DataJpaTest
public class AuthoritiesServiceTest {
    
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    UserRepository userRepository;



    @Test
    public void save1AuthoritiesSuccessfulTest(){
        UserService userService = new UserService(userRepository);
        AuthoritiesService authoritiesService = new AuthoritiesService(authoritiesRepository, userService);
        Authorities authorities = new Authorities();

        try{
            authoritiesService.saveAuthorities(authorities);
        } catch(Exception e){
            fail("Esta excepcion no deberia salir");
        }
    }

    @Test
    public void save2AuthoritiesSuccessfulTest(){
        UserService userService = new UserService(userRepository);
        AuthoritiesService authoritiesService = new AuthoritiesService(authoritiesRepository, userService);

        try{
            authoritiesService.saveAuthorities("Manpalpin02", "admin");
        } catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void save2AuthoritiesUnsuccessfulTest(){
        UserService userService = new UserService(userRepository);
        AuthoritiesService authoritiesService = new AuthoritiesService(authoritiesRepository, userService);

        assertThrows(Exception.class, () -> authoritiesService.saveAuthorities("prueba", "player"));
    }
}
