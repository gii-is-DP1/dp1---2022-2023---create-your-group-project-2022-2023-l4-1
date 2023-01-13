package org.springframework.samples.petclinic.objetos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoService {

    private ObjetoRepository objetoRepository;

    @Autowired
    public ObjetoService(ObjetoRepository objetoRepository) {
        this.objetoRepository = objetoRepository;
    }

    public Objeto findById(Integer id) {
        return objetoRepository.findById(id).get();
    }

    public List<Objeto> findAll() {
        return objetoRepository.findAll();
    }
    
}
