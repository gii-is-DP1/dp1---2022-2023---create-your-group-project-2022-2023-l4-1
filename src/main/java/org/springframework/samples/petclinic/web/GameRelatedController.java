package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameRelatedController {

    @GetMapping("/info")
    public String info(Map<String, Object> model) {
        return "info";
    }
    
}
