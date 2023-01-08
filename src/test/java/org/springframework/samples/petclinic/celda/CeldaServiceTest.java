package org.springframework.samples.petclinic.celda;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.carta.CartaRepository;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.enums.Posicion;
import org.springframework.samples.petclinic.jugador.JugadorRepository;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.PartidaRepository;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.samples.petclinic.tablero.TableroRepository;

@DataJpaTest
public class CeldaServiceTest {

    @Autowired
    CeldaRepository celdaRepository;

    @Autowired
    TableroRepository tableroRepository;

    @Autowired
    PartidaRepository partidaRepository;

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    CartaRepository cartaRepository;


    // @Test
    // public void saveSuccessfulTest(){
    //     Celda celda2 = new Celda();
    //     celda2.setPosicion(Posicion.POS1);

    //     Tablero tablero2 = new Tablero();

    //     CartaService cartaService = new CartaService(cartaRepository);
    //     CeldaService celdaService = new CeldaService(celdaRepository, cartaService);

    //     try{
    //         celdaService.save(celda2, tablero2);
    //     } catch(Exception e){
    //         // fail("Error");
    //         throw e;
    //     }
    // }
    
}
