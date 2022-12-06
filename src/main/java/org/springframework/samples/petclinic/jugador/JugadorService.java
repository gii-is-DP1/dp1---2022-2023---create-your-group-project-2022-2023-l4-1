package org.springframework.samples.petclinic.jugador;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JugadorService {

    private JugadorRepository jugadorRepository;	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthoritiesService authoritiesService;

	@Autowired
	public JugadorService(JugadorRepository jugadorRepository) {
		this.jugadorRepository = jugadorRepository;
	}	

	@Transactional(readOnly = true)
	public Jugador findOwnerById(int id) throws DataAccessException {
		return jugadorRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Collection<Jugador> findOwnerByLastName(String lastName) throws DataAccessException {
		return jugadorRepository.findByLastName(lastName);
	}

	public void save(User user) {

		Jugador jugador = new Jugador();
		jugador.setEsJugadorInicial(false);
		jugador.setEsGanador(false);
		jugador.setNumEnanosMazo(2);
		jugador.setNumEnanosPico(0);
		jugador.setCantidadHierro(0);
		jugador.setCantidadAcero(0);
		jugador.setCantidadOro(0);
		jugador.setCantidadMedallas(0);
		jugador.setUser(user);

		jugadorRepository.save(jugador);
	}

	public User getUserLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if (auth!=null) {
			if (auth.isAuthenticated() && auth.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
				org.springframework.security.core.userdetails.User userLogged = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
				username = userLogged.getUsername();
			}
		}
        return userService.findUser(username).get();
    }

	/*@Transactional
	public void saveJugador(Jugador jugador) throws DataAccessException {
		jugadorRepository.save(jugador);		
		userService.saveUser(jugador.getUser());
		authoritiesService.saveAuthorities(jugador.getUser().getUsername(), "player");
	}		*/
    
}