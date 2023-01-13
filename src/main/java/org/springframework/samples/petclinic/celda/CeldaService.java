package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.enums.Posicion;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.stereotype.Service;

@Service
public class CeldaService {

    private CeldaRepository celdaRepository;
    private CartaService cartaService;
    private JugadorService jugadorService;

    @Autowired
    public CeldaService(CeldaRepository celdaRepository, CartaService cartaService, JugadorService jugadorService) {
        this.celdaRepository = celdaRepository;
        this.cartaService = cartaService;
        this.jugadorService = jugadorService;
    }

    public Celda findById(Integer id) {
        return celdaRepository.findById(id).get();
    }

    public List<Celda> findAll() {
        return celdaRepository.findAll();
    }

    public void save(Celda celda, Tablero tablero) {
        if (celda.getPosicion() == Posicion.POS1) celda.setCartas(List.of(cartaService.findById(1)));
        else if (celda.getPosicion() == Posicion.POS2) celda.setCartas(List.of(cartaService.findById(2)));
        else if (celda.getPosicion() == Posicion.POS3) celda.setCartas(List.of(cartaService.findById(3)));
        else if (celda.getPosicion() == Posicion.POS4) celda.setCartas(List.of(cartaService.findById(4)));
        else if (celda.getPosicion() == Posicion.POS5) celda.setCartas(List.of(cartaService.findById(5)));
        else if (celda.getPosicion() == Posicion.POS6) celda.setCartas(List.of(cartaService.findById(6)));
        else if (celda.getPosicion() == Posicion.POS7) celda.setCartas(List.of(cartaService.findById(7)));
        else if (celda.getPosicion() == Posicion.POS8) celda.setCartas(List.of(cartaService.findById(8)));
        else if (celda.getPosicion() == Posicion.POS9) celda.setCartas(List.of(cartaService.findById(9)));
        celda.setOcupado(false);
        celda.setTablero(tablero);
        celdaRepository.save(celda);
    }

    public void colocarFicha(Partida partida, Tablero tablero, String username, Integer numCelda) {
        if (partida.getUser0().getUsername() == username) {
            tablero.getCeldas().get(numCelda).setFicha("/resources/images/fichas/meeple azul.png");
            tablero.getCeldas().get(numCelda).setOcupado(true);
            tablero.getCeldas().get(numCelda).setOcupadaPor(username);
            Jugador jugador1 = jugadorService.findJugadorInAGame(partida.getUser0().getUsername(), partida);
            jugador1.setNumEnanosMazo(jugador1.getNumEnanosMazo()-1);
        } else if (partida.getUser1().getUsername() == username) {
            tablero.getCeldas().get(numCelda).setFicha("/resources/images/fichas/meeple rojo.png");
            tablero.getCeldas().get(numCelda).setOcupado(true);
            tablero.getCeldas().get(numCelda).setOcupadaPor(username);
            Jugador jugador2 = jugadorService.findJugadorInAGame(partida.getUser1().getUsername(), partida);
            jugador2.setNumEnanosMazo(jugador2.getNumEnanosMazo()-1);
        } else if (partida.getUser2() != null && partida.getUser2().getUsername() == username) {
            tablero.getCeldas().get(numCelda).setFicha("/resources/images/fichas/meeple verde.png");
            tablero.getCeldas().get(numCelda).setOcupado(true);
            tablero.getCeldas().get(numCelda).setOcupadaPor(username);
            Jugador jugador3 = jugadorService.findJugadorInAGame(partida.getUser2().getUsername(), partida);
            jugador3.setNumEnanosMazo(jugador3.getNumEnanosMazo()-1);
        }
    }
    
    public Boolean comprobarSiTodasCeldasOcupadas(Tablero tablero) {
        Boolean estanTodasOcupadas = true;
        for (Integer i = 0; i <= 8; i++) {
            if (!tablero.getCeldas().get(i).getOcupado()) {
                estanTodasOcupadas = false;
                break;
            }
        }
        return estanTodasOcupadas;
    }

}
