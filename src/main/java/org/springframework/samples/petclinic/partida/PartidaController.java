package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.Authorities;
import org.springframework.samples.petclinic.web.LoggedUserController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/partida/partidas")
public class PartidaController {

    PartidaService service;

    private final String PARTIDAS_LISTING_VIEW = "/partidas/PartidasListing";

    @Autowired
    LoggedUserController currentUser;

    @Autowired
    public PartidaController(PartidaService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public ModelAndView showPartidas(){
        ModelAndView result = new ModelAndView(PARTIDAS_LISTING_VIEW);
        result.addObject("partidas", service.getPartidas());
        return result;
    }

    @GetMapping("/player")
    public ModelAndView showMisPartidas(){
        ModelAndView res = new ModelAndView(PARTIDAS_LISTING_VIEW);
        String currentUsername = currentUser.returnLoggedUserName();
        List<Partida> partidas = new ArrayList<Partida>();
        for(Partida partida : service.getPartidas()){
            if(partida.getUsernameList().contains(currentUsername)){
                partidas.add(partida);
            }
        }
        res.addObject("partidas", partidas);
        return res;
    }


    
}
