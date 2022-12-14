package org.springframework.samples.petclinic.tablero;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableroService {

    @Autowired
    TableroRepository tableroRepository;

    public Optional<Tablero> findById(Integer id) {
        return tableroRepository.findById(id);
    }
    
}
