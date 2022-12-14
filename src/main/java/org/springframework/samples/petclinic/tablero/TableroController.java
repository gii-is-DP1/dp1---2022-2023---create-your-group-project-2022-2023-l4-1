package org.springframework.samples.petclinic.tablero;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableroController {
    
    @Autowired
    TableroService tableroService;

    @GetMapping(value = "/tablero/")
    public String showTablero(Map<String, Object> model) {
        model.put("tablero", tableroService.findById(1).get());
        return "tablero";
    }

}
