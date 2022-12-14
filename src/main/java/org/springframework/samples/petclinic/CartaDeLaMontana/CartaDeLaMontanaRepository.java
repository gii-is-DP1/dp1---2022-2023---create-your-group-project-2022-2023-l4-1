package org.springframework.samples.petclinic.CartaDeLaMontana;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaDeLaMontanaRepository extends CrudRepository<CartaDeLaMontana, Integer>{
    
    
/* 
    @Query("SELECT card FROM MountainCard card WHERE card.group =:cardgroup")
    List<CartaDeLaMontana> findByGroupCards(@Param("cardgroup") Integer cardGroup) throws DataAccessException;

    @Query("SELECT card FROM MountainCard card WHERE card.group = 1 AND card.xPosition =:xposition AND card.yPosition=:yposition")
    CartaDeLaMontana findInitialCardByPosition(@Param("posicion") Integer posicion);
*/
}
