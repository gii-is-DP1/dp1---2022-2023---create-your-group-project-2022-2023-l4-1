package org.springframework.samples.petclinic.carta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    private CartaRepository cartaRepository;
    private CartaEspecialRepository cartaEspecialRepository;

    @Autowired
    public CartaService(CartaRepository cartaRepository, CartaEspecialRepository cartaEspecialRepository) {
        this.cartaRepository = cartaRepository;
        this.cartaEspecialRepository = cartaEspecialRepository;
    }

    public Carta findById(Integer id) {
        return cartaRepository.findById(id).get();
    }

    public CartaEspecial findCartaEspecialById(Integer id) {
        return cartaEspecialRepository.findById(id).get();
    }
    
}
