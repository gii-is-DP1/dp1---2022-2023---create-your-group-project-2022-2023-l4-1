package org.springframework.samples.petclinic.jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.enums.NumRondas;
import org.springframework.samples.petclinic.user.User;

@DataJpaTest
public class JugadorServiceTest {

    @Autowired
    JugadorRepository jugadorRepository;

    @Test
    public void saveSuccessfulTest(){
        User user = new User();
        user.setUsername("pruebaUsername");
        user.setPassword("pruebaPassword");
        user.setEmail("prueba@gmail.com");
        user.setNombre("pruebaNombre");
        user.setApellidos("pruebaApellidos");

        Partida partida = new Partida();
        partida.setNombreSala("pruebaSala");
        partida.setRondas(NumRondas.ILIMITADAS);

        JugadorService jugadorService = new JugadorService(jugadorRepository);

        try{
            jugadorService.save(user, partida);
        } catch(Exception e){
            fail("Error");
        }
    }

    @Test
    public void saveUnsuccessfulTest(){
        User user2 = new User();
        Partida partida2 = new Partida();
        partida2.setNombreSala(null);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        assertThrows(Exception.class, () -> jugadorService.save(user2, partida2));
    }

    @Test
    public void findJugadorByIdTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Jugador jugador = jugadorService.findJugadorById(1);
        assertNotNull(jugador);
        assertEquals("pabmarval", jugador.getUser().getUsername());
        assertEquals(1, jugador.getPartida().getId());
    }

    @Test
    public void getJugadoresTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        List<Jugador> jugadores = jugadorService.getJugadores();
        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertEquals(6, jugadores.size());
    }

    @Test
    public void findOwnerByLastNameTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Collection<Jugador> jugadores = jugadorService.findOwnerByLastName("Cortabarra Romero");
        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertEquals(2, jugadores.size());
    }

    @Test
    public void deleteByIdTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        jugadorService.deleteJugadorById(1);
        assertNull(jugadorService.findJugadorById(1));
        assertEquals(5, jugadorService.getJugadores().size());
    }
    
}
