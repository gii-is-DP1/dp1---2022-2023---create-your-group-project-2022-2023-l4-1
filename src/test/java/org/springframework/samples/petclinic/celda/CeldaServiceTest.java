package org.springframework.samples.petclinic.celda;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.CartaEspecialRepository;
import org.springframework.samples.petclinic.carta.CartaRepository;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.jugador.JugadorRepository;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.objetos.ObjetoRepository;
import org.springframework.samples.petclinic.objetos.ObjetoService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.samples.petclinic.tablero.TableroRepository;
import org.springframework.samples.petclinic.tablero.TableroService;

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
    ObjetoRepository objetoRepository;

    @Autowired
    JugadorRepository jugadorRepository;


    @Test
    public void saveSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
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
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);

        Celda celda = new Celda();
        Tablero tablero = new Tablero();

        assertThrows(Exception.class, () -> celdaService.save(celda, tablero));
    }



    @Test
    public void colocarFichaSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
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
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
                
        Tablero tablero = new Tablero();
        Partida partida = new Partida();
        Integer numCelda = 1;

        assertThrows(Exception.class, () -> celdaService.colocarFicha(partida, tablero, "davcorrom", numCelda));
    }
}
