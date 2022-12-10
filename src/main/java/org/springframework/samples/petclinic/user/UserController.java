/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.user;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ignacio Warleta
 * @author Gabriel Vacaro
 */

@Controller
public class UserController {

	private static final String USUARIOS_LISTING_VIEW = "/users/UsersListing";
	private static final String VIEWS_JUGADOR_CREATE_FORM = "users/createUserForm";
	private static final String VIEWS_JUGADOR_UPDATE_FORM = "users/updateUserForm";
	private static final String VIEW_PERFIL = "users/perfil";
	private static final String VIEW_USER_FRIENDS = "users/friends";

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users/")
    public ModelAndView showUsuarios(){
        ModelAndView result = new ModelAndView(USUARIOS_LISTING_VIEW);
        result.addObject("selections", userService.getUsuarios().stream().filter(x -> !x.getUsername().equals("admin1")).collect(Collectors.toList()));
        return result;
    }

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}


	@GetMapping(value = "/users/new")
	public String initCreationForm(Map<String, Object> model) {
		User user = new User();
		model.put("user", user);
		return VIEWS_JUGADOR_CREATE_FORM;
	}

	@PostMapping(value = "/users/new")
	public String processCreationForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_JUGADOR_CREATE_FORM;
		}
		else {
			this.userService.saveUser(user);
			return "redirect:/";
		}
	}

	@GetMapping(value = "/users/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("user", new User());
		return "users/findUsers";
	}

	@GetMapping(value = "/users")
	public String processFindForm(User user, BindingResult result, Map<String, Object> model) {

		if (user.getUsername() == null) {
			user.setUsername("");
		}

		Collection<User> results = this.userService.findUserByUsername(user.getUsername());

		if (results == null) {
			result.rejectValue("username", "notFound", "not found");
			return "users/findUsers";
		} else {
			model.put("selections", results);
			return "users/UsersListing";
		}
	}

	@GetMapping("/users/{userId}")
	public ModelAndView showUser(@PathVariable("username") int ownerId) {
		ModelAndView mav = new ModelAndView("users/");
		mav.addObject(this.userService.findUser("username"));
		return mav;
	}

	@GetMapping(path="/users/delete/{username}")
	public ModelAndView delteOrgano(@PathVariable("username") String username){		
		userService.deleteUserById(username);
		ModelAndView result=showUsuarios();		
		result.addObject("mensaje", "Usuario borrado con éxito!");		
		result.addObject("tipomensaje", "success");
		return result;
	}

	@GetMapping(value = "/users/perfil")
	public ModelAndView showPerfil() {

		// Obtención del usuario autenticado.
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if (auth!=null) {
			if (auth.isAuthenticated() && auth.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
				org.springframework.security.core.userdetails.User userLogged = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
				username = userLogged.getUsername();
			}
		}

		// Representación de los datos del perfil del usuario que ha iniciado sesión.
		ModelAndView mav = new ModelAndView(VIEW_PERFIL);
		User userToShow = this.userService.findUser(username).get();
		mav.addObject("user", userToShow);
		return mav;
	}

	@GetMapping(value = "/users/perfil/edit/{username}")
	public String initUpdateOwnerForm(@PathVariable("username") String username, Model model) {
		User user = this.userService.findUser(username).get();
		model.addAttribute(user);
		return VIEWS_JUGADOR_UPDATE_FORM;
	}

	@PostMapping(value = "/users/perfil/edit/{username}")
	public String processUpdateOwnerForm(@Valid User user, BindingResult result,
			@PathVariable("username") String username) {
		if (result.hasErrors()) {
			return VIEWS_JUGADOR_UPDATE_FORM;
		}
		else {
			user.setUsername(username);
			this.userService.saveUser(user);
			return "redirect:/users/perfil";
		}
	}


	/*@GetMapping("/{id}/delete")
    public String deleteAchievement(@PathVariable int id){
		String view = "redirect:/users/";
        userService.deleteAchievementById(id);        
        return view;
    }

	*/

	@Transactional
    @GetMapping("/users/{username}/friends")
	public ModelAndView showFriends(@PathVariable("username") String username) {
		List<User> friends = userService.getFriends(username);
		ModelAndView mav = new ModelAndView(VIEW_USER_FRIENDS);
		mav.addObject("friends", friends);
		mav.addObject("user", this.userService.findUserOptional(username).get());
		return mav;
	}

	@Transactional
	@GetMapping(value = "/users/{username}/friends/{username2}/delete")
    public String deleteFriend(@PathVariable String username, @PathVariable String username2){
        userService.Deletefriend(username, username2);        
        return "redirect:/users/"+username+"/friends";
    }


}