package org.springframework.samples.petclinic.partida;

import org.springframework.beans.factory.annotation.Autowired;
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
    public PartidaController(PartidaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView showPartidas(){
        ModelAndView res = new ModelAndView(PARTIDAS_LISTING_VIEW);
        res.addObject("partidas", service.getPartidas());
        return res;
    }
    
    

}
