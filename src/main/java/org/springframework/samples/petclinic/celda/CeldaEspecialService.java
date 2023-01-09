package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.stereotype.Service;

@Service
public class CeldaEspecialService {

    private CeldaEspecialRepository celdaEspecialRepository;

    @Autowired
    public CeldaEspecialService(CeldaEspecialRepository celdaEspecialRepository) {
        this.celdaEspecialRepository = celdaEspecialRepository;
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

    public void colocarFicha(Partida partida, Tablero tablero, String username, Integer numCelda) {
        if (partida.getUser0().getUsername() == username) {
            tablero.getCeldasEspeciales().get(numCelda).setFicha("/resources/images/fichas/meeple azul 2.png");
            tablero.getCeldasEspeciales().get(numCelda).setOcupado(true);
        } else if (partida.getUser1().getUsername() == username) {
            tablero.getCeldasEspeciales().get(numCelda).setFicha("/resources/images/fichas/meeple rojo 2.png");
            tablero.getCeldasEspeciales().get(numCelda).setOcupado(true);
        } else if (partida.getUser2() != null && partida.getUser2().getUsername() == username) {
            tablero.getCeldasEspeciales().get(numCelda).setFicha("/resources/images/fichas/meeple verde 2.png");
            tablero.getCeldasEspeciales().get(numCelda).setOcupado(true);
        }
    }
    
}
