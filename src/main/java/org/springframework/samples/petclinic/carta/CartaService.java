package org.springframework.samples.petclinic.carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.enums.TipoCarta;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.objetos.Objeto;
import org.springframework.samples.petclinic.objetos.ObjetoService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.enums.EspecialActivada;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    private CartaRepository cartaRepository;
    private CartaEspecialRepository cartaEspecialRepository;
    private ObjetoService objetoService;

    @Autowired
    public CartaService(CartaRepository cartaRepository, CartaEspecialRepository cartaEspecialRepository,
            ObjetoService objetoService) {
        this.cartaRepository = cartaRepository;
        this.cartaEspecialRepository = cartaEspecialRepository;
        this.objetoService = objetoService;
    }

    public Carta findById(Integer id) {
        return cartaRepository.findById(id).get();
    }

    public CartaEspecial findCartaEspecialById(Integer id) {
        return cartaEspecialRepository.findById(id).get();
    }

    public void cartaEspecial1(Tablero tablero) {
        for (Integer i = 0; i <= 8; i++) {
            if (tablero.getCeldas().get(i).getCartas().get(0).getTipo() == TipoCarta.Defensa) {
                tablero.getCeldas().get(i).setOcupado(true);
                tablero.getCeldas().get(i).setFicha("/resources/images/fichas/meeple.png");
            }
        }
    }

    public void cartaEspecial2(Tablero tablero) {
        for (Integer i = 0; i <= 8; i++) {
            if (tablero.getCeldas().get(i).getCartas().size() > 1) {
                Carta cartaAColocar = tablero.getCeldas().get(i).getCartas().get(0);
                tablero.getCeldas().get(i).getCartas().remove(0);
                tablero.getMontana().add(cartaAColocar);
            }
        }
    }

    public void cartaEspecial3(Jugador jugador) {
        List<Objeto> objetosDelJugador = jugador.getObjetos();
        Collections.shuffle(objetosDelJugador);
        objetosDelJugador.remove(0);
        jugador.setCantidadOro(jugador.getCantidadOro()+10);
    }

    public void cartaEspecial4(Tablero tablero, Integer posicion) {
        if (tablero.getCeldas().get(posicion).getCartas().size() > 1) {
            Carta cartaAColocar = tablero.getCeldas().get(posicion).getCartas().get(0);
            tablero.getCeldas().get(posicion).getCartas().remove(0);
            if (tablero.getCeldas().get(posicion).getCartas().size() > 2)
                tablero.getCeldas().get(posicion).getCartas().add(1, cartaAColocar);
            else tablero.getCeldas().get(posicion).getCartas().add(cartaAColocar);
        }
    }

    public void cartaEspecial5(Jugador jugador) {
        List<Objeto> objetosAConseguir = objetoService.findAll();
        List<Objeto> objetosDelJugador = jugador.getObjetos();
        List<Objeto> objetosNoConseguidosPorElJugador = new ArrayList<Objeto>();
        for (Objeto o: objetosAConseguir) {
            if (!objetosDelJugador.contains(o)) objetosNoConseguidosPorElJugador.add(o);
        }
        Collections.shuffle(objetosNoConseguidosPorElJugador);
        jugador.getObjetos().add(objetosNoConseguidosPorElJugador.get(0));
    }

    public void cartaEspecial6(Tablero tablero, Partida partida, Integer posicion, String username) {
        Carta cartaAColocar = tablero.getCeldas().get(posicion).getCartas().get(0);
        tablero.getCeldas().get(posicion).getCartas().remove(0);
        tablero.getMontana().add(cartaAColocar);
        tablero.getCeldas().get(posicion).setOcupadaPor(username);
        tablero.getCeldas().get(posicion).setOcupado(true);
        if (partida.getUser0().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple azul.png");
        if (partida.getUser1().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple rojo.png");
        if (partida.getUser2().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple verde.png");
    }

    public void cartaEspecial7(Tablero tablero, Partida partida, Integer posicion, String username) {
        tablero.getCeldas().get(posicion).setOcupadaPor(username);

        if (partida.getUser0().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple azul.png");
        if (partida.getUser1().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple rojo.png");
        if (partida.getUser2().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple verde.png");
    }

    public void cartaEspecial8(Tablero tablero) {
        for (Integer i = 0; i <= 8; i++) {
            if (tablero.getCeldas().get(i).getCartas().size() > 1) {
                Carta cartaAColocar = tablero.getCeldas().get(i).getCartas().get(0);
                tablero.getCeldas().get(i).getCartas().remove(0);
                tablero.getCeldas().get(i).getCartas().add(cartaAColocar);
            }
        }
    }

    public void cartaEspecial9(Tablero tablero) {
        List<Carta> cartas = new ArrayList<Carta>(); 
        for (Integer i = 0; i <= 8; i++) {
            Carta cartaAColocar = tablero.getCeldas().get(i).getCartas().get(0);
            cartas.add(cartaAColocar);
            tablero.getCeldas().get(i).getCartas().remove(0);
        }
        Collections.shuffle(cartas);
        for (Integer i = 0; i <= 8; i++) {
            for (Integer j = 0; j < cartas.size(); j++) {
                if (i == j) tablero.getCeldas().get(i).getCartas().add(0, cartas.get(j));
            }
        }
    }

    public void ejecutarCartaEspecial(Tablero tablero, Partida partida, Integer posicion, Jugador jugador) {
        if (posicion == 1) this.cartaEspecial1(tablero);
        else if (posicion == 2) this.cartaEspecial2(tablero);
        else if (posicion == 3) this.cartaEspecial3(jugador);
        else if (posicion == 4) partida.setEspecialActivada(EspecialActivada.ESPECIAL4);
        else if (posicion == 5) this.cartaEspecial5(jugador);
        else if (posicion == 6) partida.setEspecialActivada(EspecialActivada.ESPECIAL6);
        else if (posicion == 7) partida.setEspecialActivada(EspecialActivada.ESPECIAL7);
        else if (posicion == 8) this.cartaEspecial8(tablero);
        else if (posicion == 9) this.cartaEspecial9(tablero);
    }
    
}
