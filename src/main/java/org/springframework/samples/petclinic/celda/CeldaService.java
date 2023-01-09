package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.enums.Posicion;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.stereotype.Service;

@Service
public class CeldaService {

    private CeldaRepository celdaRepository;
    private CartaService cartaService;

    @Autowired
    public CeldaService(CeldaRepository celdaRepository, CartaService cartaService) {
        this.celdaRepository = celdaRepository;
        this.cartaService = cartaService;
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
        } else if (partida.getUser1().getUsername() == username) {
            tablero.getCeldas().get(numCelda).setFicha("/resources/images/fichas/meeple rojo.png");
            tablero.getCeldas().get(numCelda).setOcupado(true);
        } else if (partida.getUser2() != null && partida.getUser2().getUsername() == username) {
            tablero.getCeldas().get(numCelda).setFicha("/resources/images/fichas/meeple verde.png");
            tablero.getCeldas().get(numCelda).setOcupado(true);
        }
    }
    
}
