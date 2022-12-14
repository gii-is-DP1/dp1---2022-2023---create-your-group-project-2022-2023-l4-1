package org.springframework.samples.petclinic.CartaDeLaMontana;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartaDeLaMontanaService {
    
      /*

    private CartaDeLaMontanaRepository cartamontanaRepo;

    @Autowired
    public CartaDeLaMontanaService(CartaDeLaMontanaRepository cartamontanaRepo) {
        this.cartamontanaRepo = cartamontanaRepo;
    }

    @Transactional(readOnly = true)
    public Iterable<CartaDeLaMontana> findAll() {
        return cartamontanaRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<CartaDeLaMontana> findByGroupCard(Integer cardGroup){
        return cartamontanaRepo.findByGroupCards(cardGroup);
    }

    @Transactional(readOnly = true)
    public CartaDeLaMontana findInitialCardByPosition(Integer xposition, Integer yposition) {
        return cartamontanaRepo.findInitialCardByPosition(xposition, yposition);
    }

    @Transactional(readOnly = true)
    public Optional<CartaDeLaMontana> findByMountainCardId(int id){
        return cartamontanaRepo.findById(id);
    }

    @Transactional
    public void delete(CartaDeLaMontana card) {
        cartamontanaRepo.delete(card);
    }

    */



}
