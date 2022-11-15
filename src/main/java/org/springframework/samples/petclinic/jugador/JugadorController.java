package org.springframework.samples.petclinic.jugador;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JugadorController {

    private static final String VIEWS_JUGADORES_CREATE_OR_UPDATE_FORM = "jugadores/createOrUpdateJugadorForm";

	private final JugadorService jugadorService;

	@Autowired
	public JugadorController(JugadorService jugadorService, UserService userService, AuthoritiesService authoritiesService) {
		this.jugadorService = jugadorService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping(value = "/jugadores/new")
	public String initCreationForm(Map<String, Object> model) {
		Jugador jugador = new Jugador();
		model.put("jugador", jugador);
		return VIEWS_JUGADORES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/jugadores/new")
	public String processCreationForm(@Valid Jugador jugador, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_JUGADORES_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.jugadorService.saveJugador(jugador);
			
			return "redirect:/jugadores/" + jugador.getId();
		}
	}

	@GetMapping(value = "/jugadores/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("jugador", new Jugador());
		return "jugadores/findJugadores";
	}

	@GetMapping(value = "/jugadores")
	public String processFindForm(Jugador jugador, BindingResult result, Map<String, Object> model) {

		if (jugador.getUser().getApellidos() == null) {
			jugador.getUser().setApellidos("") ;
		}

		Collection<Jugador> results = this.jugadorService.findOwnerByLastName(jugador.getUser().getApellidos());
		if (results.isEmpty()) {
			result.rejectValue("apellido", "notFound", "not found");
			return "jugadores/findJugadores";
		}
		else if (results.size() == 1) {
			jugador = results.iterator().next();
			return "redirect:/jugadores/" + jugador.getId();
		}
		else {
			model.put("selections", results);
			return "jugadores/jugadoresList";
		}
	}

	@GetMapping(value = "/jugadores/{jugadorId}/edit")
	public String initUpdateJugadorForm(@PathVariable("jugadorId") int jugadorId, Model model) {
		Jugador jugador = this.jugadorService.findOwnerById(jugadorId);
		model.addAttribute(jugador);
		return VIEWS_JUGADORES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/jugadores/{jugadorId}/edit")
	public String processUpdateJugadorForm(@Valid Jugador jugador, BindingResult result,
			@PathVariable("jugadorId") int jugadorId) {
		if (result.hasErrors()) {
			return VIEWS_JUGADORES_CREATE_OR_UPDATE_FORM;
		}
		else {
			jugador.setId(jugadorId);
			this.jugadorService.saveJugador(jugador);
			return "redirect:/jugadores/{jugadorId}";
		}
	}

	@GetMapping("/jugadores/{jugadorId}")
	public ModelAndView showJugador(@PathVariable("jugadorId") int jugadorId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(this.jugadorService.findOwnerById(jugadorId));
		return mav;
	}

    
}
