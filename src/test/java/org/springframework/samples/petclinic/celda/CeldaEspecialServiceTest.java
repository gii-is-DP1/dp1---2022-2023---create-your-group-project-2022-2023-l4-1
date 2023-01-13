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
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.samples.petclinic.tablero.TableroRepository;
import org.springframework.samples.petclinic.tablero.TableroService;

@DataJpaTest
public class CeldaEspecialServiceTest {
    
    @Autowired
    CeldaEspecialRepository celdaEspecialRepository;

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    CartaEspecialRepository cartaEspecialRepository;

    @Autowired
    ObjetoRepository objetoRepository;

    @Autowired
    TableroRepository tableroRepository;

    @Autowired
    CeldaRepository celdaRepository;



    @Test
    public void saveSuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);

        Tablero tablero = tableroService.findById(1).get();
        CeldaEspecial celdaEspecial = new CeldaEspecial();

        try{
            celdaEspecialService.save(celdaEspecial, tablero);
        } catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void saveUnsuccessfulTest(){
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);

        Tablero tablero = new Tablero();
        CeldaEspecial celdaEspecial = new CeldaEspecial();

        assertThrows(Exception.class, () -> celdaEspecialService.save(celdaEspecial, tablero));
    }
}
