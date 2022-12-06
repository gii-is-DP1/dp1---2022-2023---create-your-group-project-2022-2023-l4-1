package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.partida.enums.NumRondas;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserService;
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

    PartidaService partidaService;
    UserService userService;

    private final String MIS_PARTIDAS_LISTING_VIEW = "/partidas/MisPartidasListing";
    private final String PARTIDAS_LISTING_VIEW = "/partidas/PartidasListing";
    private final String PARTIDAS_FORM = "/partidas/createOrUpdatePartidaForm";
    private final String PARTIDAS_ACTIVAS_VIEW = "partidas/partidasActivasListing";

    @Autowired
    LoggedUserController currentUser;

    @Autowired
    public PartidaController(PartidaService partidaService, UserService userService) {
        this.partidaService = partidaService;
        this.userService = userService;
    }

    @GetMapping("/partidas")
    public ModelAndView showPartidas(){
        ModelAndView res = new ModelAndView(PARTIDAS_LISTING_VIEW);
        res.addObject("partidas", partidaService.getPartidas());
        return res;
    }


    @Transactional(readOnly = true)
    @GetMapping("/misPartidas")
    public ModelAndView showMisPartidas(){
        ModelAndView res = new ModelAndView(MIS_PARTIDAS_LISTING_VIEW);
        String currentUsername = currentUser.returnLoggedUserName();
        User userLogged = userService.findUser(currentUsername).get();

        List<Partida> partidas = new ArrayList<Partida>();

        for(int i=0 ; i < partidaService.getPartidas().size();i++){
            Partida partida = partidaService.getPartidas().get(i);

            if(partida.getUsersOnTheGame().contains(userLogged)){
                partidas.add(partida);
            }
        }

        res.addObject("partidas", partidas);

        return res;
    }

    @Transactional(readOnly = true)
    @GetMapping("/partidasActivas")
    public ModelAndView partidasActivas(){
        ModelAndView res = new ModelAndView(PARTIDAS_ACTIVAS_VIEW);
        List<Partida> partidas = new ArrayList<Partida>();
        for(int i=0 ; i < service.getPartidas().size();i++){
            Partida partida = service.getPartidas().get(i);
            if(partida.getGanador()==null){
                partidas.add(partida);
            }
        }
        res.addObject("partidas", partidas);
        return res;
    }

    @Transactional()
    @GetMapping("/{id}/delete")
    public ModelAndView deletePartida(@PathVariable int id){
        partidaService.deletePartidaById(id);        
        return showPartidas();

    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/create")
	public String initCreationForm(Map<String, Object> model) {
		Partida partida = new Partida();
		model.put("partida", partida);
        model.put("numRondas", Arrays.asList(NumRondas.values()));
		return PARTIDAS_FORM;
	}

    @Transactional()
	@PostMapping(value = "/create")
	public String processCreationForm(@Valid Partida partida, BindingResult result) {
		if (result.hasErrors()) {
			return PARTIDAS_FORM;
		}
		else {
			this.partidaService.save(partida);
			return "redirect:/";
		}
	}
 
}