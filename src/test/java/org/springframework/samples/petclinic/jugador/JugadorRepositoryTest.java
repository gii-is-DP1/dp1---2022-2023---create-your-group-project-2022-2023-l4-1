package org.springframework.samples.petclinic.jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JugadorRepositoryTest {
    
    @Autowired
    JugadorRepository jugadorRepository;

    @Test
    public void findAllSuccessfulTest(){
        List<Jugador> jugadores = jugadorRepository.findAll();
        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertEquals(6, jugadores.size());
    }

    // @Test
    // public void findByLastNameSuccessfulTest(){
    //     Collection<Jugador> jugadores = jugadorRepository.findByLastName("Martínez Valladares");
    //     assertNotNull(jugadores);
    //     assertFalse(jugadores.isEmpty());
    //     assertEquals(2, jugadores.size());
    // }

    // @Test
    // public void findByLastNameUnsuccessfulTest(){
    //     Collection<Jugador> jugadores = jugadorRepository.findByLastName("Palacios Pineda");
    //     assertNotNull(jugadores);
    //     assertTrue(jugadores.isEmpty());
    // }

    @Test
    public void findByIdSuccessfulTest(){
        Jugador jugador = jugadorRepository.findById(1);
        assertNotNull(jugador);
        assertTrue(jugador.getUser().getUsername().equals("pabmarval"));
        assertTrue(jugador.getPartida().getId().equals(1));
    }

    @Test
    public void findByIdUnsuccessfulTest(){
        Jugador jugador = jugadorRepository.findById(46);
        assertNull(jugador);
    }

    @Test
    public void findByUsernameSuccessfulTest(){
        Collection<Jugador> jugadores = jugadorRepository.findByUsername("davcorrom");
        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertEquals(2, jugadores.size());
    }

    @Test
    public void findByUsernameUnsuccessfulTest(){
        Collection<Jugador> jugadores = jugadorRepository.findByUsername("usuarioFalso");
        assertNotNull(jugadores);
        assertTrue(jugadores.isEmpty());
    }
}
