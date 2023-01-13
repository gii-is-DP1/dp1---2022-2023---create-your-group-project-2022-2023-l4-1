package org.springframework.samples.petclinic.partida;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.CartaEspecialRepository;
import org.springframework.samples.petclinic.carta.CartaRepository;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.CeldaEspecialRepository;
import org.springframework.samples.petclinic.celda.CeldaEspecialService;
import org.springframework.samples.petclinic.celda.CeldaRepository;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorRepository;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.objetos.ObjetoRepository;
import org.springframework.samples.petclinic.objetos.ObjetoService;
import org.springframework.samples.petclinic.tablero.TableroRepository;
import org.springframework.samples.petclinic.tablero.TableroService;
import org.springframework.samples.petclinic.user.Authorities;
import org.springframework.samples.petclinic.user.AuthoritiesRepository;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.samples.petclinic.user.UserService;

@DataJpaTest
public class PartidaServiceTest {
    
    @Autowired
    PartidaRepository partidaRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    TableroRepository tableroRepository;

    @Autowired
    CeldaRepository celdaRepository;

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    CartaEspecialRepository cartaEspecialRepository;

    @Autowired
    ObjetoRepository objetoRepository;

    @Autowired
    CeldaEspecialRepository celdaEspecialRepository;



    @Test
    public void getPartidasTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);
        
        List<Partida> partidas = partidaService.getPartidas();

        assertNotNull(partidas);
        assertFalse(partidas.isEmpty());
        assertEquals(2, partidas.size());
    }



    @Test
    public void getAuthorityByUsernameSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);
        
        Authorities authority = partidaService.getAuthorityByUsername("pabmarval");

        assertNotNull(authority);
        assertEquals(authority.getAuthority(), "player");
    }

    @Test
    public void getAuthorityByUsernameUnsuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);
        
        Authorities authority = partidaService.getAuthorityByUsername("prueba");

        assertNull(authority);
    }



    @Test
    public void findPartidaByIdSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        Partida partida = partidaService.findPartidaById(1);

        assertNotNull(partida);
        assertEquals("prueba", partida.getNombreSala());
    }

    @Test
    public void findPartidaByIdUnsuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        assertThrows(Exception.class, () -> partidaService.findPartidaById(235457));
    }



    @Test
    public void deleteSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        Partida partida = partidaService.findPartidaById(2);
        
        try{
            partidaService.delete(partida);
        } catch(Exception e){
            fail(e);
        }
    }



    @Test
    public void deletePartidaByIdSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);
        
        try{
            partidaService.deletePartidaById(2);
        } catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void deletePartidaByIdUnsuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);
        
        assertThrows(Exception.class, () -> partidaService.deletePartidaById(345));
    }



    @Test
    public void getPlayersInAGameSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        List<Jugador> jugadores = partidaService.getPlayersInAGame(1);

        assertNotNull(jugadores);
        assertFalse(jugadores.isEmpty());
        assertEquals("pabmarval", jugadores.get(0).getUser().getUsername());
        assertEquals("ignwarmur", jugadores.get(1).getUser().getUsername());
        assertEquals("davcorrom", jugadores.get(2).getUser().getUsername());
    }

    @Test
    public void getPlayersInAGameUnsuccesfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        assertTrue(partidaService.getPlayersInAGame(32546).isEmpty());
    }



    @Test
    public void getNumTotalFichasMazoSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        Partida partida = partidaService.findPartidaById(1);

        assertNotNull(partidaService.getNumTotalFichasMazo(partida));
        assertEquals(6, partidaService.getNumTotalFichasMazo(partida));
    }

    @Test
    public void getNumTotalFichasMazoUnsuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        assertThrows(Exception.class, () -> partidaService.getNumTotalFichasMazo(new Partida()));
    }



    @Test
    public void getNumTotalFichasPicoSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        Partida partida = partidaService.findPartidaById(1);

        assertNotNull(partidaService.getNumTotalFichasPico(partida));
        assertEquals(6, partidaService.getNumTotalFichasPico(partida));
    }

    @Test
    public void getNumTotalFichasPicoUnsuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        assertThrows(Exception.class, () -> partidaService.getNumTotalFichasPico(new Partida()));
    }



    @Test
    public void actualizarTurnoSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        Partida partida = partidaService.findPartidaById(1);
        
        try{
            partidaService.actualizarTurno(partida);
        } catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void actualizarTurnoUnsuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        UserService userService = new UserService(userRepository);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
            tableroService, celdaService, cartaService);

        assertThrows(Exception.class, () -> partidaService.actualizarTurno(new Partida()));
    }
}
