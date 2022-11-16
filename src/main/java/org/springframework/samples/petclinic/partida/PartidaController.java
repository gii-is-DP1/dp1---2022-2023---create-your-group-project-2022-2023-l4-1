package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.partida.enums.NumRondas;
import org.springframework.samples.petclinic.web.LoggedUserController;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/partida")
public class PartidaController {

    PartidaService service;

    private final String MIS_PARTIDAS_LISTING_VIEW = "/partidas/MisPartidasListing";
    private final String PARTIDAS_LISTING_VIEW = "/partidas/PartidasListing";
    private final String PARTIDAS_FORM = "/partidas/createOrUpdatePartidaForm";

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
        ModelAndView res = new ModelAndView(MIS_PARTIDAS_LISTING_VIEW);
        String currentUsername = currentUser.returnLoggedUserName();
        List<Partida> partidas = new ArrayList<Partida>();

        for(int i=0 ; i < service.getPartidas().size();i++){
            Partida partida = service.getPartidas().get(i);

            if(partida.getUsernameList().contains(currentUsername)){
                partidas.add(partida);
            }
        }

        res.addObject("partidas", partidas);

        return res;
    }

    @Transactional()
    @GetMapping("/{id}/delete")
    public ModelAndView deletePartida(@PathVariable int id){
        service.deletePartidaById(id);        
        return showPartidas();

    }

    @Transactional(readOnly = true)
    @GetMapping("/new")
    public ModelAndView createPartida(){
        Partida partida = new Partida();
        ModelAndView result = new ModelAndView(PARTIDAS_FORM);        
        result.addObject("partida", partida);
        result.addObject("numRondas", Arrays.asList(NumRondas.values()));        
        return result;
    }

    @Transactional
    @PostMapping("/new")
    public ModelAndView saveNewPartida(@Valid Partida partida, BindingResult br){
        ModelAndView result = null;
        if(br.hasErrors()){
            result = new ModelAndView(PARTIDAS_FORM, br.getModel());
            result.addObject("numRondas",Arrays.asList(NumRondas.values()));                  
            return result;
        }
        service.save(partida);
        result = showPartidas();
        result.addObject("message", "La partida fue creada correctamente.");
        return result;
    }
 
}