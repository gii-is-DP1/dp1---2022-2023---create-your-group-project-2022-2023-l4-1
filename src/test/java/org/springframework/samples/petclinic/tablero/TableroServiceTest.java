package org.springframework.samples.petclinic.tablero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.springframework.samples.petclinic.partida.Partida;

@DataJpaTest
public class TableroServiceTest {
    
    @Autowired
    TableroRepository tableroRepository;

    @Autowired
    CeldaRepository celdaRepository;

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    CeldaEspecialRepository celdaEspecialRepository;

    @Autowired
    CartaEspecialRepository cartaEspecialRepository;



    @Test
    public void saveSuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        Partida partida = new Partida();

        try{
            tableroService.save(partida);
        } catch(Exception e){
            fail("Esta excepcion no deberia salir");
        }
    }



    @Test
    public void findByIdSuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        Tablero tablero = tableroService.findById(1).get();

        assertNotNull(tablero);
        assertEquals("resources/images/cueva-juego.png", tablero.getBackground());
        assertEquals(800, tablero.getHeight());
    }

    @Test
    public void findByIdUnsuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
    
        assertThrows(Exception.class, () -> tableroService.findById(1325457).get());
    }



    @Test
    public void findAllTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        List<Tablero> tableros = tableroService.findAll();

        assertNotNull(tableros);
        assertFalse(tableros.isEmpty());
        assertEquals(1, tableros.size());
    }
}
