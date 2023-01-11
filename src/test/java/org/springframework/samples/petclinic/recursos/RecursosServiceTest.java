package org.springframework.samples.petclinic.recursos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.recurso.Recursos;
import org.springframework.samples.petclinic.recurso.RecursosRepository;
import org.springframework.samples.petclinic.recurso.RecursosService;
import org.springframework.samples.petclinic.recurso.enums.TipoRecurso;

@DataJpaTest
public class RecursosServiceTest {
    
    @Autowired
    RecursosRepository recursosRepository;

    @Test
    public void saveSuccessfulTest(){
        Recursos recurso = new Recursos();
        recurso.setNombre(TipoRecurso.Acero);
        recurso.setCantidadBase(2);

        RecursosService recursosService = new RecursosService(recursosRepository);

        try{
            recursosService.saveResources(recurso);
        } catch(Exception e){
            fail("Esta excepción no debería salir");
        }
    }

    @Test
    public void saveUnsuccessfulTest(){
        Recursos recurso = new Recursos();
        RecursosService recursosService = new RecursosService(recursosRepository);
        assertThrows(Exception.class, () -> recursosService.saveResources(recurso));
    }



    @Test
    public void recursosCountTest(){
        RecursosService recursosService = new RecursosService(recursosRepository);
        assertNotNull(recursosService.RecursosCount());
        assertEquals(0, recursosService.RecursosCount());
    }



    @Test
    public void findAllTest(){
        RecursosService recursosService = new RecursosService(recursosRepository);
        assertNotNull(recursosService.findAll());
    }



    // @Test
    // public void findByResourcesId(){
    //     RecursosService recursosService = new RecursosService(recursosRepository);
    //     Optional<Recursos> recursos = recursosService.findByResourcesId(1);
    // }
}
