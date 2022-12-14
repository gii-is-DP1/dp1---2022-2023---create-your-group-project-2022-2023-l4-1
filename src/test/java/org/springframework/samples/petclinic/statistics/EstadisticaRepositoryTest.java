package org.springframework.samples.petclinic.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EstadisticaRepositoryTest {

    @Autowired
    EstadisticaRepository estadisticaRepository;
    
    @Test
    public void findAllSuccessfulTest(){
        Collection<Estadistica> estadisticas = estadisticaRepository.findAll();
        assertNotNull(estadisticas);
        assertFalse(estadisticas.isEmpty());
        assertEquals(1, estadisticas.size());
    }

    @Test
    public void findByIDSuccessfulTest(){
        Estadistica estadistica = estadisticaRepository.findByID(1);
        assertNotNull(estadistica);
        assertTrue(estadistica.getHierroTotal().equals(15));
        assertTrue(estadistica.getUser().getUsername().equals("admin1"));
    }

    @Test
    public void findByIDUnsuccessfulTest(){
        Estadistica estadistica = estadisticaRepository.findByID(125443);
        assertNull(estadistica);
    }

    @Test
    public void findByUsernameSuccesfulTest(){
        Estadistica estadistica = estadisticaRepository.findByUsername("admin1").get();
        assertNotNull(estadistica);
        assertTrue(estadistica.getHierroTotal().equals(15));
        assertTrue(estadistica.getId().equals(1));
    }

    // @Test
    // public void findByUsernameUnsuccesfulTest(){
    //     Estadistica estadistica = estadisticaRepository.findByUsername("usuarioFalso").get();
    //     assertNull(estadistica);
    // }
}
