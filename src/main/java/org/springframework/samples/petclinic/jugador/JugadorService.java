package org.springframework.samples.petclinic.jugador;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.partida.Partida;
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
	public Jugador findJugadorById(int id) throws DataAccessException {
		return jugadorRepository.findById(id);
	}

	public List<Jugador> getJugadores() {
		return jugadorRepository.findAll();
	}

	public Jugador findJugadorInAGame(String username, Partida partida) {
		return jugadorRepository.findJugadorInAGame(username, partida);
	}

	@Transactional(readOnly = true)
	public Collection<Jugador> findOwnerByLastName(String lastName) throws DataAccessException {
		return jugadorRepository.findByLastName(lastName);
	}

	public void deleteJugadorById(int id){
        jugadorRepository.deleteById(id);
    }

	public void save(User user, Partida partida) throws Exception{

		Jugador jugador = new Jugador();
		jugador.setEsJugadorInicial(false);
		jugador.setEsGanador(false);
		jugador.setNumEnanosMazo(2);
		jugador.setNumEnanosPico(0);
		jugador.setCantidadHierro(0);
		jugador.setCantidadAcero(0);
		jugador.setCantidadOro(0);
		jugador.setCantidadMedallas(0);
		jugador.setPuedeObtenerObjeto(false);
		jugador.setUser(user);
		jugador.setPartida(partida);

		if(jugador.getPartida().getNombreSala().equals(null) || jugador.getPartida().getRondas().equals(null)){
			throw new Exception();
		} else if(jugador.getUser().getUsername().equals(null) || jugador.getUser().getPassword().equals(null) || 
					jugador.getUser().getEmail().equals(null) || jugador.getUser().getNombre().isEmpty() || jugador.getUser().getApellidos().isEmpty()){
			throw new Exception();
		}

		jugadorRepository.save(jugador);
	}
    
}