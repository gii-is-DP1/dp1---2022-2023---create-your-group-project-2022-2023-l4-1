package org.springframework.samples.petclinic.carta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.enums.AccionEspecial;
import org.springframework.samples.petclinic.carta.enums.AccionPosterior;
import org.springframework.samples.petclinic.carta.enums.NombreCarta;
import org.springframework.samples.petclinic.carta.enums.RangoCarta;
import org.springframework.samples.petclinic.carta.enums.TipoCarta;
import org.springframework.samples.petclinic.celda.CeldaEspecialRepository;
import org.springframework.samples.petclinic.celda.CeldaEspecialService;
import org.springframework.samples.petclinic.celda.CeldaRepository;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorRepository;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.objetos.Objeto;
import org.springframework.samples.petclinic.objetos.ObjetoRepository;
import org.springframework.samples.petclinic.objetos.ObjetoService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.samples.petclinic.tablero.TableroRepository;
import org.springframework.samples.petclinic.tablero.TableroService;

@DataJpaTest
public class CartaServiceTest {

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    CartaEspecialRepository cartaEspecialRepository;

    @Autowired
    ObjetoRepository objetoRepository;

    @Autowired
    TableroRepository tableroRepository;

    @Autowired
    CeldaRepository celdaRepository;

    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    CeldaEspecialRepository celdaEspecialRepository;
    

    
    @Test
    public void findByIdSuccessfulTest(){
      ObjetoService objetoService = new ObjetoService(objetoRepository);
      JugadorService jugadorService = new JugadorService(jugadorRepository);
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);

      Carta carta = cartaService.findById(23);

      assertNotNull(carta);
      assertEquals(NombreCarta.Alloy_Steel, carta.getNombre());
      assertEquals(TipoCarta.Extraccion, carta.getTipo());
      assertEquals(RangoCarta.B, carta.getRango());
      assertEquals("Return 3 iron to the supply then take 2 steel.", carta.getDescripcion());
      assertEquals(5, carta.getPosicion());
      assertEquals("/resources/images/cartas/Carta 23.png", carta.getImagen());
    }

    @Test
    public void findByIdUnsuccessfulTest(){
      ObjetoService objetoService = new ObjetoService(objetoRepository);
      JugadorService jugadorService = new JugadorService(jugadorRepository);
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);

      assertThrows(Exception.class, () -> cartaService.findById(80));
    }



    @Test
    public void findCartaEspecialByIdSuccessfulTest(){
      ObjetoService objetoService = new ObjetoService(objetoRepository);
      JugadorService jugadorService = new JugadorService(jugadorRepository);
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);

      CartaEspecial cartaEspecial = cartaService.findCartaEspecialById(3);

      assertNotNull(cartaEspecial);
      assertEquals(AccionEspecial.Sell_an_Item, cartaEspecial.getNombre());
      assertEquals(AccionPosterior.Iron_Seam, cartaEspecial.getAccionPosterior());
      assertEquals("Take 3 iron from the supply.", cartaEspecial.getDescripcionTrasera());
      assertEquals("/resources/images/cartas_especiales/Especial 3.png", cartaEspecial.getImagenEspecial());
    }

    @Test
    public void findCartaEspecialByIdUnsuccessfulTest(){
      ObjetoService objetoService = new ObjetoService(objetoRepository);
      JugadorService jugadorService = new JugadorService(jugadorRepository);
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);

      assertThrows(Exception.class, () -> cartaService.findCartaEspecialById(20));
    }



    @Test
    public void ejecutarCartaEspecialSuccessfulTest(){
      JugadorService jugadorService = new JugadorService(jugadorRepository);
      ObjetoService objetoService = new ObjetoService(objetoRepository);
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
      CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
      CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
      TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);

      Tablero tablero = tableroService.findById(1).get();
      Partida partida = tablero.getPartida();
      Jugador jugador = jugadorService.findJugadorInAGame("pabmarval", partida);
      Objeto objeto = new Objeto();
      List<Objeto> objetos = new ArrayList<Objeto>();
      objetos.add(objeto);
      jugador.setObjetos(objetos);

      try{
        cartaService.ejecutarCartaEspecial(tablero, partida, 3, jugador);
      } catch(Exception e){
        fail(e);
      }
    }

    @Test
    public void ejecutarCartaEspecialUnsuccessfulTest(){
      JugadorService jugadorService = new JugadorService(jugadorRepository);
      ObjetoService objetoService = new ObjetoService(objetoRepository);
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
      CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
      CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
      TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);

      Tablero tablero = tableroService.findById(1).get();
      Partida partida = tablero.getPartida();
      Jugador jugador = jugadorService.findJugadorInAGame("pabmarval", partida);

      assertThrows(Exception.class, () -> cartaService.ejecutarCartaEspecial(tablero, partida, 3, jugador));
    }
  }
