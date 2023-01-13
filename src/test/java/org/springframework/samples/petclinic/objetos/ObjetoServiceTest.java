package org.springframework.samples.petclinic.objetos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ObjetoServiceTest {
    
    @Autowired
    ObjetoRepository objetoRepository;



    @Test
    public void findAllTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        List<Objeto> objetos = objetoService.findAll();

        assertNotNull(objetos);
        assertFalse(objetos.isEmpty());
        assertEquals(8, objetos.size());
    }



    @Test
    public void findByIdSuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);
        Objeto objeto = objetoService.findById(3);

        assertNotNull(objeto);
        assertEquals("Diadema", objeto.getNombre());
    }

    @Test
    public void findByIdUnsuccessfulTest(){
        ObjetoService objetoService = new ObjetoService(objetoRepository);

        assertThrows(Exception.class, () -> objetoService.findById(34647));
    }
}
