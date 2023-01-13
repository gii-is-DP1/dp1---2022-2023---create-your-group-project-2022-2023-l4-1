package org.springframework.samples.petclinic.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.samples.petclinic.user.UserService;

@DataJpaTest
public class EstadisticaServiceTest {
    
    @Autowired
    EstadisticaRepository estadisticaRepository;

    @Autowired
    UserRepository userRepository;



    @Test
    public void newStatisticsSuccessfulTest(){
        EstadisticaService estadisticaService = new EstadisticaService(estadisticaRepository);
        UserService userService = new UserService(userRepository);

        User user = userService.findUser("Manpalpin02").get();

        try{
            estadisticaService.newStatistics(user);
        } catch(Exception e){
            fail("Esta excepcion no deberia salir");
        }
    }

    @Test
    public void newStatisticsUnsuccessfulTest(){
        EstadisticaService estadisticaService = new EstadisticaService(estadisticaRepository);

        User user = new User();

        assertThrows(Exception.class, () -> estadisticaService.newStatistics(user));
    }



    @Test
    public void findAllTest(){
        EstadisticaService estadisticaService = new EstadisticaService(estadisticaRepository);

        Collection<Estadistica> estadisticas = estadisticaService.findAll();

        assertNotNull(estadisticas);
        assertFalse(estadisticas.isEmpty());
        assertEquals(1, estadisticas.size());
    }



    @Test
    public void findStatisticsByIDSuccessfulTest(){
        EstadisticaService estadisticaService = new EstadisticaService(estadisticaRepository);

        Estadistica estadistica = estadisticaService.findStatisticsByID(1);

        assertNotNull(estadistica);
        assertEquals("admin1", estadistica.getUser().getUsername());
        assertEquals(15, estadistica.getHierroTotal());
    }

    @Test
    public void findStatisticsByIDUnsuccessfulTest(){
        EstadisticaService estadisticaService = new EstadisticaService(estadisticaRepository);

        Estadistica estadistica = estadisticaService.findStatisticsByID(34675675);

        assertNull(estadistica);
    }



    @Test
    public void findStatisticsByUsernameSuccessfulTest(){
        EstadisticaService estadisticaService = new EstadisticaService(estadisticaRepository);

        Estadistica estadistica = estadisticaService.findStatisticsByUsername("admin1").get();

        assertNotNull(estadistica);
        assertEquals(1, estadistica.getId());
        assertEquals(15, estadistica.getHierroTotal());
    }

    @Test
    public void findStatisticsByUsernameUnsuccessfulTest(){
        EstadisticaService estadisticaService = new EstadisticaService(estadisticaRepository);
        
        assertThrows(Exception.class, () -> estadisticaService.findStatisticsByUsername("prueba").get());
    }
}
