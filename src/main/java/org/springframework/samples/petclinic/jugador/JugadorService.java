package org.springframework.samples.petclinic.jugador;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.UserService;
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

	/*@Transactional
	public void saveJugador(Jugador jugador) throws DataAccessException {
		jugadorRepository.save(jugador);		
		userService.saveUser(jugador.getUser());
		authoritiesService.saveAuthorities(jugador.getUser().getUsername(), "player");
	}		*/
    
}