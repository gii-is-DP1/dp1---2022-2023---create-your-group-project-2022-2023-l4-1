package org.springframework.samples.petclinic.partida;

import static org.junit.jupiter.api.Assertions.fail;

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
import org.springframework.samples.petclinic.jugador.JugadorRepository;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.objetos.ObjetoRepository;
import org.springframework.samples.petclinic.objetos.ObjetoService;
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

    @Autowired
    CartaEspecialRepository cartaEspecialRepository;

    @Autowired
    ObjetoRepository objetoRepository;

    @Autowired
    CeldaEspecialRepository celdaEspecialRepository;


    // @Test
    // public void saveSuccessfulTest(){
    //     ObjetoService objetoService = new ObjetoService(objetoRepository);
    //     CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService);
    //     JugadorService jugadorService = new JugadorService(jugadorRepository);
    //     CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
    //     UserService userService = new UserService(userRepository);
    //     CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
    //     TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
    //     PartidaService partidaService = new PartidaService(partidaRepository, authoritiesRepository, userService, jugadorService, 
    //         tableroService, celdaService);
        
    //     Partida partida = new Partida();
    //     partida.setNombreSala("sala");
    //     partida.setRondas(NumRondas.ILIMITADAS);

    //     try{
    //         partidaService.save(partida);
    //     } catch(Exception e){
    //         fail(e);
    //     }
    // }
}
