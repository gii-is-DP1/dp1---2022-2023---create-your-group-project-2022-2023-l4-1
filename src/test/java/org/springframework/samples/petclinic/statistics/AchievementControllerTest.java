package org.springframework.samples.petclinic.statistics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.petclinic.configuration.SecurityConfiguration;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.samples.petclinic.web.LoggedUserController;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(controllers=AchievementController.class,
    excludeFilters=@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes=WebSecurityConfigurer.class),
    excludeAutoConfiguration=SecurityConfiguration.class)
public class AchievementControllerTest {

    public static final String ID_ACHIEVEMENT_TO_EDIT = "1";
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AchievementService achievementService;
    @MockBean
    private UserService userService;
    @MockBean
    private LoggedUserController currentUser;
    
    @WithMockUser
    @Test
    public void testAchievementListing() throws Exception{
        mockMvc.perform(get("/statistics/achievements/")).
                andExpect(status().isOk()).
                andExpect(view().name("/achievements/AchievementsListing")).
                andExpect(model().attributeExists("achievements"));
    }

    @WithMockUser
    @Test
    public void testCreateNewAchievement() throws Exception{
        mockMvc.perform(get("/statistics/achievements/new")).
                andExpect(status().isOk()).
                andExpect(view().name("/achievements/createOrUpdateAchievementForm")).
                andExpect(model().attributeExists("achievement"));
    }

    @WithMockUser
    @Test
    public void testEditAchievement() throws Exception{
        when(achievementService.getById(anyInt())).thenReturn(new Achievement());

        mockMvc.perform(get("/statistics/achievements/{id}/edit", ID_ACHIEVEMENT_TO_EDIT)).
                andExpect(status().isOk()).
                andExpect(view().name("/achievements/createOrUpdateAchievementForm")).
                andExpect(model().attributeExists("achievement"));
    }

    @WithMockUser
    @Test
    public void testAchievementUpdateUnsuccessful() throws Exception{
        when(achievementService.getById(anyInt())).thenReturn(new Achievement());

        mockMvc.perform(post("/statistics/achievements/{id}/edit",ID_ACHIEVEMENT_TO_EDIT).
                            with(csrf()).
                            param("name","Enano Supremo, la Venganza")).
                andExpect(status().isOk()).
                andExpect(view().name("/achievements/createOrUpdateAchievementForm")).
                andExpect(model().attributeExists("achievement"));
    }

    @WithMockUser
    @Test
    public void testAchievementUpdateSuccessful() throws Exception{
        when(achievementService.getById(anyInt())).thenReturn(new Achievement());

        mockMvc.perform(post("/statistics/achievements/{id}/edit",ID_ACHIEVEMENT_TO_EDIT).
                            with(csrf()).
                            param("name","Enano Supremo, la Venganza").
                            param("description","Toma tu venganza frente a un antiguo rival").
                            param("badgeImage", "ejemploDeImagen.png").
                            param("threshold", "10.0")).
                andExpect(status().isOk()).
                andExpect(view().name("/achievements/AchievementsListing")).
                andExpect(model().attributeExists("achievement"));
    }
}
