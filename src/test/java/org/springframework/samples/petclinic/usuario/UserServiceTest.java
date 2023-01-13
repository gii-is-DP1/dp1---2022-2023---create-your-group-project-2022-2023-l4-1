package org.springframework.samples.petclinic.usuario;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.user.AuthoritiesRepository;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.samples.petclinic.user.UserService;

@DataJpaTest
public class UserServiceTest {
    
    @Autowired
    UserRepository userRepository;



    // @Test
    // public void saveSuccessfulTest(){
    //     UserService userService = new UserService(userRepository);
    //     User user = new User();
    //     user.setUsername("pruebaUsername");

    //     try{
    //         userService.saveUser(user);
    //     } catch(Exception e){
    //         fail(e);
    //     }
    // }
}
