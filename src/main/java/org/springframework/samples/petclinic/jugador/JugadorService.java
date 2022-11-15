package org.springframework.samples.petclinic.jugador;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.UserService;

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
	public Jugador findJugadorById(int id) throws DataAccessException {
		return jugadorRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Collection<Jugador> findJugadorByLastName(String lastName) throws DataAccessException {
		return jugadorRepository.findByLastName(lastName);
	}

	@Transactional
	public void saveJugador(Jugador jugador) throws DataAccessException {
		//creating owner
		jugadorRepository.save(jugador);		
		//creating user
		userService.saveUser(jugador.getUser());
		//creating authorities
		authoritiesService.saveAuthorities(jugador.getUser().getUsername(), "jugador");
	}		
    
}
