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

    @GetMapping("/")
    public ModelAndView showPartidas(){
        ModelAndView res = new ModelAndView(PARTIDAS_LISTING_VIEW);
        // String currentUsername = currentUser.returnLoggedUserName();
        // Authorities authority = service.getAuthorityByUsername(currentUsername);
        // String role = authority.getAuthority();

        // if(role == "player"){
        //     List<Partida> partidas = new ArrayList<Partida>();
        //     for(Partida partida : service.getPartidas()){
        //         if(partida.getUsernameList().contains(currentUsername)){
        //             partidas.add(partida);
        //         }
        //     }
        //     res.addObject("partidas", partidas);
        //     return res;
        // }
        res.addObject("partidas", service.getPartidas());
        return res;
    }

    /* 
    @GetMapping("/{partidaId}/delete")
	public String deletePlayer(@PathVariable("partidaId") Integer partidaId,ModelMap modelMap) throws Exception {
		String view = "redirect:/partida/partidas/";
		Partida partida = service.findPartidaById(partidaId);
		service.delete(partida);
		modelMap.addAttribute("message", "Partida deleted!");
		return view;
	}
*/

    @Transactional()
    @GetMapping("/{id}/delete")
    public ModelAndView deletePartida(@PathVariable int id){
        service.deletePartidaById(id);        
        return showPartidas();

    }


    
}
