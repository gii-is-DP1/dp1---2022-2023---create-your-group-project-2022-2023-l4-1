package org.springframework.samples.petclinic.jugador;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JugadorService {

    private JugadorRepository jugadorRepository;	

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
    
}