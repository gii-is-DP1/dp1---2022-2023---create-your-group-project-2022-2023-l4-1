package org.springframework.samples.petclinic.web;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.samples.petclinic.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	
	  @GetMapping({"/","/welcome"})
	  public String welcome(Map<String, Object> model) {

		List <Person> persons = new ArrayList<Person>();

		Person person1 = new Person();
		person1.setFirstName("David");
		person1.setLastName("Cortabarra Romero");
		persons.add(person1);

		Person person2 = new Person();
		person2.setFirstName("Daniel");
		person2.setLastName("Guedes Preciados");
		persons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Pablo");
		person3.setLastName("Martínez Valladares");
		persons.add(person3);

		Person person4 = new Person();
		person4.setFirstName("Manuel");
		person4.setLastName("Palacios Pineda");
		persons.add(person4);

		Person person5 = new Person();
		person5.setFirstName("Gabriel María");
		person5.setLastName("Vacaro Goytia");
		persons.add(person5);

		Person person6 = new Person();
		person6.setFirstName("Ignacio");
		person6.setLastName("Warleta Murcia");
		persons.add(person6);

		model.put("persons", persons);
		model.put("title", "Dwarf");
		model.put("group", "L4-1");
	    return "welcome";
	  }
}