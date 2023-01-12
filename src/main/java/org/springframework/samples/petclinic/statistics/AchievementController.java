package org.springframework.samples.petclinic.statistics;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.samples.petclinic.web.LoggedUserController;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/statistics/achievements")
public class AchievementController {

    private final String MY_ACHIEVEMENTS_LISTING_VIEW="/achievements/MyAchievementListing";
    private final String ACHIEVEMENTS_LISTING_VIEW="/achievements/AchievementsListing";
    private final String ACHIEVEMENTS_FORM="/achievements/createOrUpdateAchievementForm";

    private AchievementService service;
    private UserService userService;
    private LoggedUserController currentUser;

    @Autowired(required = true)
    public AchievementController(AchievementService service, UserService userService, LoggedUserController currentUser){
        this.service=service;
        this.userService = userService;
        this.currentUser = currentUser;
    }


    @Transactional(readOnly = true)
    @GetMapping("/")
    public ModelAndView showAchievements(){
        ModelAndView result=new ModelAndView(ACHIEVEMENTS_LISTING_VIEW);
        result.addObject("achievements", service.getAchievements());
        return result;
    }
    
    @Transactional(readOnly = true)
    @GetMapping("/myAchievements")
    public ModelAndView showMyAchievements(){
        ModelAndView result=new ModelAndView(MY_ACHIEVEMENTS_LISTING_VIEW);
        String currentUsername = currentUser.returnLoggedUserName();
        User actualUser = userService.findUser(currentUsername).get();
        List<Achievement> logros = new ArrayList<Achievement>(actualUser.getAchievements());
        result.addObject("achievements", logros);
        return result;
    }

    @Transactional()
    @GetMapping("/{id}/delete")
    public ModelAndView deleteAchievement(@PathVariable int id){
        service.deleteAchievementById(id);        
        return showAchievements();
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}/edit")
    public String editAchievement(@PathVariable("id") int achievementId, ModelMap model){
        Achievement achievement=service.getById(achievementId);        
        model.addAttribute(achievement);
        return ACHIEVEMENTS_FORM;
    }
 
    @Transactional
    @PostMapping("/{id}/edit")
    public ModelAndView saveAchievement(@PathVariable("id") int achievementId,@Valid Achievement achievement, BindingResult br, ModelMap model) {
        if(br.hasErrors()){
            return new ModelAndView(ACHIEVEMENTS_FORM,br.getModel());            
        }
        Achievement achievementToBeUpdated=service.getById(achievementId);
        BeanUtils.copyProperties(achievement,achievementToBeUpdated,"id");
        service.save2(achievementToBeUpdated);
        model.put("message", "The achievement was updated successfully");
        return showAchievements();        
    }

    @Transactional(readOnly = true)
    @GetMapping("/new")
    public ModelAndView createAchievement(){
        Achievement achievement=new Achievement();
        ModelAndView result=new ModelAndView(ACHIEVEMENTS_FORM);
        result.addObject("achievement", achievement);
        return result;
    }

    @Transactional
    @PostMapping("/new")
    public ModelAndView saveNewAchievement(@Valid Achievement achievement, BindingResult br) throws Exception{
        if(br.hasErrors()){
            return new ModelAndView(ACHIEVEMENTS_FORM,br.getModel());            
        }
        service.save(achievement);
        ModelAndView result=showAchievements();
        result.addObject("message", "The achievement was created successfully");
        return result;
    }
    
}