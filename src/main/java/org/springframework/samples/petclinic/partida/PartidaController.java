package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.Authorities;
import org.springframework.samples.petclinic.web.LoggedUserController;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/partida")
public class PartidaController {

    PartidaService service;

    private final String PARTIDAS_LISTING_VIEW = "/partidas/PartidasListing";

    @Autowired
    LoggedUserController currentUser;

    @Autowired
    public PartidaController(PartidaService service) {
        this.service = service;
    }

    @GetMapping("/partidas")
    public ModelAndView showPartidas(){
        ModelAndView res = new ModelAndView(PARTIDAS_LISTING_VIEW);
        res.addObject("partidas", service.getPartidas());
        return res;
    }

    @Transactional(readOnly = true)
    @GetMapping("/misPartidas")
    public ModelAndView showMisPartidas(){
        ModelAndView res = new ModelAndView(PARTIDAS_LISTING_VIEW);
        String currentUsername = currentUser.returnLoggedUserName();
        List<Partida> partidas = new ArrayList<Partida>();
        for(int i=0 ; i < service.getPartidas().size();i++){
            Partida partida = service.getPartidas().get(i);
            if(partida.getUsernameList().contains(currentUsername)){
                partidas.add(partida);
            }
        }
        res.addObject("partidas", service.getPartidas());
        return res;
    }


    @Transactional()
    @GetMapping("/{id}/delete")
    public ModelAndView deletePartida(@PathVariable int id){
        service.deletePartidaById(id);        
        return showPartidas();

    }


    
}
