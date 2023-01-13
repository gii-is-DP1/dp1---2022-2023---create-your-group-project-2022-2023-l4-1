package org.springframework.samples.petclinic.statistics;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.jugador.JugadorRepository;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.samples.petclinic.user.UserService;

@ExtendWith(MockitoExtension.class)
public class AchievementServiceTest {
    
    @Mock
    AchievementRepository achievementRepository;

    @Mock
    JugadorRepository jugadorRepository;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void config(){
        Achievement achievement1 = new Achievement();
        achievement1.setName("Acaparador");
        List<Achievement> achievements = new ArrayList<Achievement>();
        achievements.add(achievement1);
        when(achievementRepository.findByName(any(String.class))).thenReturn(achievements);
    }

    @Test
    public void saveUnsuccessfulTest(){
        Achievement achievement2 = new Achievement();
        achievement2.setName("Acaparador");
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        UserService userService = new UserService(userRepository);
        AchievementService achievementService = new AchievementService(achievementRepository, jugadorService, userService);

        assertThrows(Exception.class, () -> achievementService.save(achievement2));
    }

    @Test
    public void saveSuccessfulTest(){
        Achievement achievement3 = new Achievement();
        achievement3.setName("Prueba de achievement");
        achievement3.setDescription("Prueba de descripcion");
        JugadorService jugadorService = new JugadorService(jugadorRepository);
        UserService userService = new UserService(userRepository);
        AchievementService achievementService = new AchievementService(achievementRepository, jugadorService, userService);
        try{
            achievementService.save(achievement3);
        } catch(Exception e){
            fail("Esta excepcion no debería ser lanzada");
        }
    }
}
