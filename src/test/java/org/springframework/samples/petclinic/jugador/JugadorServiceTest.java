package org.springframework.samples.petclinic.jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.PartidaRepository;
import org.springframework.samples.petclinic.partida.enums.NumRondas;
import org.springframework.samples.petclinic.user.User;

@DataJpaTest
public class JugadorServiceTest {

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    PartidaRepository partidaRepository;



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
    public void findJugadorByIdSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Jugador jugador = jugadorService.findJugadorById(1);
        assertNotNull(jugador);
        assertEquals("pabmarval", jugador.getUser().getUsername());
        assertEquals(1, jugador.getPartida().getId());
    }

    @Test
    public void findJugadorByIdUnsuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Jugador jugador = jugadorService.findJugadorById(1304);
        assertNull(jugador);
    }



    @Test
    public void getJugadoresSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        List<Jugador> jugadores = jugadorService.getJugadores();
        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertEquals(6, jugadores.size());
    }

    @Test
    public void getJugadoresUnsuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        List<Jugador> jugadores = jugadorService.getJugadores();
        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertNotEquals(1254, jugadores.size());
    }


    
    @Test
    public void findOwnerByLastNameSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Collection<Jugador> jugadores = jugadorService.findOwnerByLastName("Cortabarra Romero");
        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertEquals(2, jugadores.size());
    }

    @Test
    public void findOwnerByLastNameUnsuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Collection<Jugador> jugadores = jugadorService.findOwnerByLastName("Palacios Pineda");
        assertNotNull(jugadores);
        assertTrue(jugadores.isEmpty());
    }



    @Test
    public void deleteByIdSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        jugadorService.deleteJugadorById(1);
        assertNull(jugadorService.findJugadorById(1));
        assertEquals(5, jugadorService.getJugadores().size());
    }

    @Test
    public void deleteByIdUnsuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        assertThrows(Exception.class, () -> jugadorService.deleteJugadorById(35));
    }



    @Test
    public void findJugadorInAGameSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Partida partida = partidaRepository.findById(1);
        Jugador jugador = jugadorService.findJugadorInAGame("pabmarval", partida);
        assertNotNull(jugador);
        assertEquals(15, jugador.getCantidadHierro());
        assertEquals(1, jugador.getId());
    }

    @Test
    public void findJugadorInAGameUnsuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        Partida partida = partidaRepository.findById(1);
        Jugador jugador = jugadorService.findJugadorInAGame("Manpalpin02", partida);
        assertNull(jugador);
    }
    
}
