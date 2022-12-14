package org.springframework.samples.petclinic.CartaDeLaMontana;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaDeLaMontanaRepository extends CrudRepository<CartaDeLaMontana, Integer>{
    
}
