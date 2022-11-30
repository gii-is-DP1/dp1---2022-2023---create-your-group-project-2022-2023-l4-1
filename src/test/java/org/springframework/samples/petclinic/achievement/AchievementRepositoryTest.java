package org.springframework.samples.petclinic.achievement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.samples.petclinic.statistics.Achievement;
import org.springframework.samples.petclinic.statistics.AchievementRepository;

@DataJpaTest
public class AchievementRepositoryTest {
    
    @Autowired
    AchievementRepository achievementRepository;

    @Test
    public void initialDataAndFindAllSuccessTest(){
        List<Achievement> achievements = achievementRepository.findAll();
        assertNotNull(achievements);
        assertFalse(achievements.isEmpty());
        assertEquals(10, achievements.size());
    }

    @Test
    public void findAchievementByNameSuccessTest(){
        List<Achievement> achievements = achievementRepository.findByName("Acaparador");
        assertNotNull(achievements);
        assertFalse(achievements.isEmpty());
        assertEquals(1, achievements.size());
    }

    @Test
    public void findAchievementByNameFailTest(){
        List<Achievement> achievements = achievementRepository.findByName("PruebaTest");
        assertNotNull(achievements);
        assertTrue(achievements.isEmpty());
    }
    
}
