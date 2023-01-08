package org.springframework.samples.petclinic.celda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
        celdaEspecialRepository.save(celdaEspecial);
    }
    
}
