package org.springframework.samples.petclinic.partida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.user.Authorities;
import org.springframework.samples.petclinic.user.AuthoritiesRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PartidaService {

    PartidaRepository repo;
    AuthoritiesRepository authRepo;
    
    @Autowired
    public PartidaService(PartidaRepository repo, AuthoritiesRepository authRepo) {
        this.repo = repo;
        this.authRepo = authRepo;
    }

    @Transactional(readOnly = true)
	public Partida findPartidaById(int id) throws DataAccessException {
		return repo.findById(id).get();
	}

    List<Partida> getPartidas(){
        return repo.findAll();
    }

    Authorities getAuthorityByUsername(String username){
        return authRepo.findByUser(username);
    }

    @Transactional(rollbackFor = Exception.class)
	public void delete(Partida partida) throws Exception{
		repo.delete(partida);
	}

    public void deletePartidaById(int id){
        repo.deleteById(id);
    }

    public void save(Partida partida){
        Jugador jugador0 = new Jugador();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        partida.setDuracion(0);
        partida.setNumRonda(1);
        partida.setTiempoRestRonda(60);
        partida.setJugadorActivo(1);
        partida.setSiguienteJugador(2);
        partida.setJugador0(jugador0);
        partida.setJugador1(jugador1);
        partida.setJugador2(jugador2);
        partida.setGanador(jugador1);
        repo.save(partida);
    }

}