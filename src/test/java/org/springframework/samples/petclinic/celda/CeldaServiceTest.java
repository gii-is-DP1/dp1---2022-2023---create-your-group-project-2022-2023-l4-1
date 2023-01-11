package org.springframework.samples.petclinic.celda;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.CartaEspecialRepository;
import org.springframework.samples.petclinic.carta.CartaRepository;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.PartidaRepository;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.samples.petclinic.tablero.TableroRepository;
import org.springframework.samples.petclinic.tablero.TableroService;
import org.springframework.samples.petclinic.user.AuthoritiesRepository;

@DataJpaTest
public class CeldaServiceTest {

    @Autowired
    CeldaRepository celdaRepository;

    @Autowired
    TableroRepository tableroRepository;

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    CartaEspecialRepository cartaEspecialRepository;

    @Autowired
    CeldaEspecialRepository celdaEspecialRepository;

    @Autowired
    PartidaRepository partidaRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;


    @Test
    public void saveSuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);
        tableroService.save(new Partida());

        Tablero tablero2 = tableroService.findById(2).get();
        Celda celda2 = new Celda();

        try{
            celdaService.save(celda2, tablero2);
        } catch(Exception e){
            fail("Esta excepcion no deberia salir");
        }
    }

    @Test
    public void saveUnsuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);

        Celda celda = new Celda();
        Tablero tablero = new Tablero();

        assertThrows(Exception.class, () -> celdaService.save(celda, tablero));
    }



    @Test
    public void colocarFichaSuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);

        Tablero tablero = tableroService.findById(1).get();
        Partida partida = tablero.getPartida();
        Integer numCelda = 0;

        try{
            celdaService.colocarFicha(partida, tablero, "pabmarval", numCelda);
        } catch(Exception e){
            fail(e);
        }
    }


    @Test
    public void colocarFichaUnsuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService);
                
        Tablero tablero = new Tablero();
        Partida partida = new Partida();
        Integer numCelda = 1;

        assertThrows(Exception.class, () -> celdaService.colocarFicha(partida, tablero, "davcorrom", numCelda));
    }
}
