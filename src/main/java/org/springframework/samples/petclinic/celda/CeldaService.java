package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.stereotype.Service;

@Service
public class CeldaService {

    private CeldaRepository celdaRepository;

    @Autowired
    public CeldaService(CeldaRepository celdaRepository) {
        this.celdaRepository = celdaRepository;
    }

    public Celda findById(Integer id) {
        return celdaRepository.findById(id).get();
    }

    public List<Celda> findAll() {
        return celdaRepository.findAll();
    }

    public void save(Celda celda, Tablero tablero) {
        celda.setTablero(tablero);
        celdaRepository.save(celda);
    }
    
}
