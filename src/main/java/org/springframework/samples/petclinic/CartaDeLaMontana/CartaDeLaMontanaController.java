package org.springframework.samples.petclinic.CartaDeLaMontana;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.partida.PartidaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartaDeLaMontanaController {
    
  /*

    private CartaDeLaMontana mountainCardService;
    private TableroService tableroService;

    @Autowired
    public CartaDeLaMontanaController (CartaDeLaMontana mountainCardService, PartidaService partidaService, TableroService tableroService) {
        this.mountainCardService = mountainCardService;
        this.tableroService = tableroService;

    }

    @GetMapping()
    public String listMountainCards(@PathVariable("partidaId") Integer tableroId, ModelMap modelMap) {
        Tablero actualTablero = tableroService.findByTableroId(tableroId).get();
        List<Celda> celdasTablero = actualTablero.getBoardCells();
        modelMap.addAttribute("Celdas", celdasTablero);

        return "";
    }

    */

    
}
