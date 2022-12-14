package org.springframework.samples.petclinic.partida;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PartidaRepositoryTest {

    @Autowired
    PartidaRepository partidaRepository;


    @Test
    public void findAllSuccessfulTest(){
        List<Partida> partidas = partidaRepository.findAll();
        assertNotNull(partidas);
        assertFalse(partidas.isEmpty());
        assertEquals(2, partidas.size());
    }
    
    @Test
    public void findByIdSuccessfulTest(){
        Partida partida = partidaRepository.findById(1);
        assertNotNull(partida);
        assertTrue(partida.getNombreSala().equals("prueba"));
        assertTrue(partida.getGanador().getUsername().equals("pabmarval"));
    }

    @Test
    public void findByIdUnsuccessfulTest(){
        Partida partida = partidaRepository.findById(46);
        assertNull(partida);
    }
}
