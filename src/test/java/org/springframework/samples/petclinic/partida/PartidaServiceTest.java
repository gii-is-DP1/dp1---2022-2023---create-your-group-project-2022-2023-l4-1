package org.springframework.samples.petclinic.partida;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.CartaRepository;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.CeldaRepository;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.jugador.JugadorRepository;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.partida.enums.NumRondas;
import org.springframework.samples.petclinic.tablero.TableroRepository;
import org.springframework.samples.petclinic.tablero.TableroService;
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


    // @Test
    // public void saveSuccessfulTest(){
    //     Partida partida = new Partida();
    //     partida.setNombreSala("sala");
    //     partida.setRondas(NumRondas.ILIMITADAS);
    //     CartaService cartaService = new CartaService(cartaRepository);
    //     CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
    //     UserService userService = new UserService(userRepository);
    //     JugadorService jugadorService = new JugadorService(jugadorRepository);
    //     TableroService tableroService = new TableroService(tableroRepository, celdaService);
    //     PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, tableroService);

    //     try{
    //         partidaService.save(partida);
    //     } catch(Exception e){
    //         fail(e);
    //     }
    // }
}
