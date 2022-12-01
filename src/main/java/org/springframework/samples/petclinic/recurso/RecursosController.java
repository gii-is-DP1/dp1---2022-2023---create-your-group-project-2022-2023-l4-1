package org.springframework.samples.petclinic.recurso;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/recursos")
public class RecursosController {

    private static final String VIEWS_RESOURCES_CREATE_OR_UPDATE_FORM = "resources/createOrUpdateResourcesForm";

	private RecursosService recursosService;

	@Autowired
	public RecursosController(RecursosService recursosService) {
		this.recursosService = recursosService;
	}

	@GetMapping()
	public String listRecursos(ModelMap modelMap) {
		String view = "resources/listResources";
		Iterable<Recursos> recursos = recursosService.findAll();
		modelMap.addAttribute("recursos", recursos);
		return view;

	}
	
    //UPDATE

	@GetMapping(value = "/{recursosId}/edit")
	public String initUpdateOwnerForm(@PathVariable("resourcesId") int resourcesId, Model model) {
		Recursos recursos = this.recursosService.findByResourcesId(resourcesId).get();
		model.addAttribute(recursos);
		return VIEWS_RESOURCES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/{recursosId}/edit")
	public String processUpdateOwnerForm(@Valid Recursos recursos, BindingResult result,
			@PathVariable("recursosId") int recursosId) {
		if (result.hasErrors()) {
			return VIEWS_RESOURCES_CREATE_OR_UPDATE_FORM;
		}
		else {
			recursos.setId(recursosId);
			this.recursosService.saveResources(recursos);
			return "redirect:/recursos";
		}
	}
    
}
