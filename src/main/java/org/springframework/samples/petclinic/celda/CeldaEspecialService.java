package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.stereotype.Service;

@Service
public class CeldaEspecialService {

    private CeldaEspecialRepository celdaEspecialRepository;
    private JugadorService jugadorService;
    private CartaService cartaService;

    @Autowired
    public CeldaEspecialService(CeldaEspecialRepository celdaEspecialRepository, JugadorService jugadorService, CartaService cartaService) {
        this.celdaEspecialRepository = celdaEspecialRepository;
        this.jugadorService = jugadorService;
        this.cartaService = cartaService;
    }

    public CeldaEspecial findById(Integer id) {
        return celdaEspecialRepository.findById(id).get();
    }

    public List<CeldaEspecial> findAll() {
        return celdaEspecialRepository.findAll();
    }

    public void save(CeldaEspecial celdaEspecial, Tablero tablero) {
        celdaEspecial.setTablero(tablero);
        celdaEspecial.setOcupado(false);
        celdaEspecialRepository.save(celdaEspecial);
    }

    public Carta obtenerCartaAColocar(Tablero tablero, Integer numCelda) {
        Carta cartaAColocar = new Carta();
        for (Integer i = 1; i <= 9; i++) {
            if (tablero.getCeldasEspeciales().get(numCelda).getCartas().get(0).getPosicion() == i)
                cartaAColocar = cartaService.findById(i+54);
        }
        return cartaAColocar;
    }

    public void elegirCarta(Partida partida, Tablero tablero, String username, Integer numCelda) {
        if (partida.getUser0().getUsername() == username) {
            Jugador jugador1 = jugadorService.findJugadorInAGame(partida.getUser0().getUsername(), partida);
            if (jugador1.getNumEnanosMazo() == 2) jugador1.setNumEnanosMazo(jugador1.getNumEnanosMazo()-2);
            else {
                jugador1.setNumEnanosMazo(jugador1.getNumEnanosMazo()-1);
                jugador1.setCantidadMedallas(jugador1.getCantidadMedallas()-4);
            }
            cartaService.ejecutarCartaEspecial(tablero, partida, this.obtenerCartaAColocar(tablero, numCelda).getPosicion(), jugador1);
        } else if (partida.getUser1().getUsername() == username) {
            Jugador jugador2 = jugadorService.findJugadorInAGame(partida.getUser1().getUsername(), partida);
            if (jugador2.getNumEnanosMazo() == 2) jugador2.setNumEnanosMazo(jugador2.getNumEnanosMazo()-2);
            else {
                jugador2.setNumEnanosMazo(jugador2.getNumEnanosMazo()-1);
                jugador2.setCantidadMedallas(jugador2.getCantidadMedallas()-4);
            }
            cartaService.ejecutarCartaEspecial(tablero, partida, this.obtenerCartaAColocar(tablero, numCelda).getPosicion(), jugador2);
        } else if (partida.getUser2() != null && partida.getUser2().getUsername() == username) {
            Jugador jugador3 = jugadorService.findJugadorInAGame(partida.getUser2().getUsername(), partida);
            if (jugador3.getNumEnanosMazo() == 2) jugador3.setNumEnanosMazo(jugador3.getNumEnanosMazo()-2);
            else {
                jugador3.setNumEnanosMazo(jugador3.getNumEnanosMazo()-1);
                jugador3.setCantidadMedallas(jugador3.getCantidadMedallas()-4);
            }
            cartaService.ejecutarCartaEspecial(tablero, partida, this.obtenerCartaAColocar(tablero, numCelda).getPosicion(), jugador3);
        }
    }

    public void colocarCartaEspecial(Tablero tablero, Integer numCelda) {
        Carta cartaAColocar = this.obtenerCartaAColocar(tablero, numCelda);
        for (Integer i = 1; i <= 9; i++) {
            if (cartaAColocar.getPosicion() == i) {
                tablero.getCeldas().get(i-1).getCartas().add(0, cartaAColocar);
                tablero.getCeldasEspeciales().get(numCelda).getCartas().remove(0);
            }
        }
    }

    public void colocarCartaEspecial2(Tablero tablero, Integer posicion) {
        for (Integer i = 1; i<= 9; i++) {
            if (posicion == i) tablero.getCeldas().get(3).getCartas().add(0, cartaService.findById(i+54));
        }
        for (CeldaEspecial c: tablero.getCeldasEspeciales()) {
            if (c.getCartas().get(0).getPosicion() == posicion) c.getCartas().remove(0);
        }
    }
    
}
