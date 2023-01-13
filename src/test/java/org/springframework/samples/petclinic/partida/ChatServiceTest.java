package org.springframework.samples.petclinic.partida;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.springframework.samples.petclinic.tablero.TableroRepository;
import org.springframework.samples.petclinic.tablero.TableroService;

@DataJpaTest
public class ChatServiceTest {
    
    @Autowired
    ChatRepository chatRepository;

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
    JugadorRepository jugadorRepository;

    @Autowired
    CeldaEspecialRepository celdaEspecialRepository;



    @Test
    public void saveSuccessfulTest(){
        ChatService chatService = new ChatService(chatRepository);
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository, objetoService, jugadorService);
        CeldaService celdaService = new CeldaService(celdaRepository, cartaService, jugadorService);
        CeldaEspecialService celdaEspecialService = new CeldaEspecialService(celdaEspecialRepository, jugadorService, cartaService);
        TableroService tableroService = new TableroService(tableroRepository, celdaService, cartaService, celdaEspecialService);

        Partida partida = tableroService.findById(1).get().getPartida();
        Chat chat = new Chat();
        chat.setPartida(partida);

        try{
            chatService.saveChat(chat);
        } catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void saveUnsuccessfulTest(){
        ChatService chatService = new ChatService(chatRepository);
        Chat chat = new Chat();

        assertThrows(Exception.class, () -> chatService.saveChat(chat));
    }
}
