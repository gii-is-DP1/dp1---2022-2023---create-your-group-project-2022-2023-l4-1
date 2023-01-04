package org.springframework.samples.petclinic.carta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    private CartaRepository cartaRepository;

    @Autowired
    public CartaService(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }

    public Carta findById(Integer id) {
        return cartaRepository.findById(id).get();
    }
    
}
