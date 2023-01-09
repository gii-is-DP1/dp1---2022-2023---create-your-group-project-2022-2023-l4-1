package org.springframework.samples.petclinic.carta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.enums.NombreCarta;
import org.springframework.samples.petclinic.carta.enums.RangoCarta;
import org.springframework.samples.petclinic.carta.enums.TipoCarta;

@DataJpaTest
public class CartaServiceTest {

//     @Autowired
//     CartaRepository cartaRepository;

//     CartaService cartaService = new CartaService(cartaRepository);
    
//     @Test
//     public void findByIdSuccessfulTest(){
//         CartaService cartaService = new CartaService(cartaRepository);
//         Carta carta = cartaService.findById(23);
//         assertNotNull(carta);
//         assertEquals(NombreCarta.Alloy_Steel, carta.getNombre());
//         assertEquals(TipoCarta.Extraccion, carta.getTipo());
//         assertEquals(RangoCarta.B, carta.getRango());
//         assertEquals("Return 3 iron to the supply then take 2 steel.", carta.getDescripcion());
//         assertEquals(5, carta.getPosicion());
//         assertEquals("imagen", carta.getImagen());
//     }
  }
