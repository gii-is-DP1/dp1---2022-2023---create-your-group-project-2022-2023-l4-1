package org.springframework.samples.petclinic.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepo;

    @Test
    public void initialDataFindAllSuccessTest() {
        List<User> usuarios = userRepo.findAll();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
    }

    @Test
    public void findUserByUsernameSuccessTest() {
        Collection<User> usuarios = userRepo.findUserByUsername("davcorrom");
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        assertEquals(1, usuarios.size());
    }

    @Test
    public void findUserByUsernameFallTest() {
        Collection<User> usuarios = userRepo.findUserByUsername("usuario completamente falso");
        assertNotNull(usuarios);
        assertTrue(usuarios.isEmpty());
    }

    @Test
    public void findSpecificUserByUsernameSuccessTest() {
        User usuario = userRepo.findByUsername("danguepre").get();
        assertNotNull(usuario);
        assertEquals("danguepre", usuario.getUsername());
    }
    
}