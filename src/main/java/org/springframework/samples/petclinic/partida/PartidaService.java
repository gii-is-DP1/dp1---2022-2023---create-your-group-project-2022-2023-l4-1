package org.springframework.samples.petclinic.partida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.partida.enums.Fase;
import org.springframework.samples.petclinic.user.Authorities;
import org.springframework.samples.petclinic.user.AuthoritiesRepository;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.samples.petclinic.web.LoggedUserController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PartidaService {

    PartidaRepository partidaRepository;
    AuthoritiesRepository authRepo;
    UserService userService;
    LoggedUserController loggedUser;
    
    @Autowired
    public PartidaService(PartidaRepository partidaRepository, AuthoritiesRepository authRepo, UserService userService) {
        this.partidaRepository = partidaRepository;
        this.authRepo = authRepo;
        this.userService = userService;
    }

    List<Partida> getPartidas(){
        return partidaRepository.findAll();
    }

    Authorities getAuthorityByUsername(String username){
        return authRepo.findByUser(username);
    }

    @Transactional(readOnly = true)
    public Partida findPartidaById(Integer id) throws DataAccessException {
        return partidaRepository.findById(id).get();
    }

    @Transactional(rollbackFor = Exception.class)
	public void delete(Partida partida) throws Exception{
		partidaRepository.delete(partida);
	}

    public void deletePartidaById(int id){
        partidaRepository.deleteById(id);
    }

    public void save(Partida partida) {

        partida.setDuracion(0);
        partida.setFaseActual(Fase.INICIANDO);
        partida.setJugadorActivo(1);
        partida.setNumRonda(0);
        partida.setSiguienteJugador(2);
        partida.setTiempoRestRonda(60);
        partida.setUser0(getUserLogged());

        partidaRepository.save(partida);
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

}