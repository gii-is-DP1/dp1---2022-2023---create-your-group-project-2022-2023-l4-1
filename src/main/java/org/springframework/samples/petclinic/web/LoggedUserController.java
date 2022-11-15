package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

@Controller
public class LoggedUserController {
	
	private UserService userService;
	
	@Autowired
	public LoggedUserController(UserService userService) {
		this.userService = userService;
	}

	
	public String returnLoggedUserName() {
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			if (auth.isAuthenticated() && auth.getPrincipal() instanceof User) {
				User user = (User) auth.getPrincipal();
				return user.getUsername();
			}
			
		}
		return null;
	}
	
	// public User loggedPlayer() {
	// 	String playerUsername = this.returnLoggedUserName();
	// 	User player;
	// 	if (playerUsername == null) {
	// 		player = new User();
	// 		player.setLastName("Not Logged");
	// 		player.setFirstName("Guest");
	// 	} else {
	// 		player = playerService.findPlayerByUserName(playerUsername);
	// 	}
		
	// 	return player;
	// }
	
}