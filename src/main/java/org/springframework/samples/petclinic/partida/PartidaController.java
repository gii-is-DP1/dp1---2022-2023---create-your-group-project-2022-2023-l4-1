package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.partida.enums.Fase;
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
    JugadorService jugadorService;

    private final String MIS_PARTIDAS_LISTING_VIEW = "/partidas/MisPartidasListing";
    private final String PARTIDAS_LISTING_VIEW = "/partidas/PartidasListing";
    private final String PARTIDAS_FORM = "/partidas/createOrUpdatePartidaForm";
    private final String PARTIDAS_ACTIVAS_VIEW = "partidas/partidasActivasListing";
    private final String LOBBY_VIEW = "partidas/Lobby";

    @Autowired
    LoggedUserController currentUser;

    @Autowired
    public PartidaController(PartidaService partidaService, UserService userService, JugadorService jugadorService) {
        this.partidaService = partidaService;
        this.userService = userService;
        this.jugadorService = jugadorService;
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

        for (Partida partida: partidaService.getPartidas()) {
            if (partida.getUsersOnTheGame().contains(userLogged)) partidas.add(partida);
        }

        res.addObject("partidas", partidas);
        return res;
    }

    @Transactional(readOnly = true)
    @GetMapping("/partidasActivas")
    public ModelAndView partidasActivas(){
        
        ModelAndView res = new ModelAndView(PARTIDAS_ACTIVAS_VIEW);
        List<Partida> partidas = new ArrayList<Partida>();

        for (Partida partida: partidaService.getPartidas()){
            if (partida.getFaseActual() == Fase.INICIANDO) partidas.add(partida);
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
	public String processCreationForm(@Valid Partida partida, BindingResult result, Map<String, Object> model) {
		if (result.hasErrors()) {
			return PARTIDAS_FORM;
		}
		else {
			this.partidaService.save(partida);
            Integer id_sala = partida.getId();
			return "redirect:../lobby/" + id_sala;
		}
	}

    @Transactional()
    @GetMapping("lobby/{id_sala}")
    public ModelAndView goToLobby(@PathVariable("id_sala") Integer id_sala, HttpServletResponse response) {

        // Refresco de página.
        response.addHeader("Refresh", "5");

        ModelAndView res = new ModelAndView(LOBBY_VIEW); // Muestra el lobby de la partida.
        Partida partida = partidaService.findPartidaById(id_sala); // Obtiene la partida que se acaba de crear.

        // Para los usuarios que deseen unirse a una partida.
        // Si el usuario no se encuentra en la partida...
        if (!partida.getUsersOnTheGame().contains(partidaService.getUserLogged())) {
            jugadorService.save(partidaService.getUserLogged()); // Se guarda un nuevo jugador relacionado al usuario que se une a la partida.

            // Si la partida tiene 1 solo jugador entonces el nuevo usuario será el usuario 2 de la partida.
            if (partida.getUser1() == null) partida.setUser1(partidaService.getUserLogged());
            // Si la partida tiene 2 jugadores entonces el nuevo usuario será el usuario 3 de la partida.
            else {
                if (partida.getUser2() == null) partida.setUser2(partidaService.getUserLogged());
            } 
        }

        res.addObject("partida", partida);
        return res;
    }
 
}