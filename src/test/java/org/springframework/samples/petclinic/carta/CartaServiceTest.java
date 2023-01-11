package org.springframework.samples.petclinic.carta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.carta.enums.AccionEspecial;
import org.springframework.samples.petclinic.carta.enums.AccionPosterior;
import org.springframework.samples.petclinic.carta.enums.NombreCarta;
import org.springframework.samples.petclinic.carta.enums.RangoCarta;
import org.springframework.samples.petclinic.carta.enums.TipoCarta;

@DataJpaTest
public class CartaServiceTest {

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    CartaEspecialRepository cartaEspecialRepository;
    

    
    @Test
    public void findByIdSuccessfulTest(){
        CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
        Carta carta = cartaService.findById(23);
        assertNotNull(carta);
        assertEquals(NombreCarta.Alloy_Steel, carta.getNombre());
        assertEquals(TipoCarta.Extraccion, carta.getTipo());
        assertEquals(RangoCarta.B, carta.getRango());
        assertEquals("Return 3 iron to the supply then take 2 steel.", carta.getDescripcion());
        assertEquals(5, carta.getPosicion());
        assertEquals("/resources/images/cartas/Carta 23.png", carta.getImagen());
    }

    @Test
    public void findByIdUnsuccessfulTest(){
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
      assertThrows(Exception.class, () -> cartaService.findById(80));
      
    }



    @Test
    public void findCartaEspecialByIdSuccessfulTest(){
      CartaService cartasService = new CartaService(cartaRepository, cartaEspecialRepository);
      CartaEspecial cartaEspecial = cartasService.findCartaEspecialById(3);
      assertNotNull(cartaEspecial);
      assertEquals(AccionEspecial.Sell_an_Item, cartaEspecial.getNombre());
      assertEquals(AccionPosterior.Iron_Seam, cartaEspecial.getAccionPosterior());
      assertEquals("Take 3 iron from the supply.", cartaEspecial.getDescripcionTrasera());
      assertEquals("/resources/images/cartas_especiales/Especial 3.png", cartaEspecial.getImagenEspecial());
    }

    @Test
    public void findCartaEspecialByIdUnsuccessfulTest(){
      CartaService cartaService = new CartaService(cartaRepository, cartaEspecialRepository);
      assertThrows(Exception.class, () -> cartaService.findCartaEspecialById(20));
      
    }
  }
