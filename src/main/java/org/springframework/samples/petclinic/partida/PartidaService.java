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

    PartidaRepository repo;
    AuthoritiesRepository authRepo;
    UserService userService;
    LoggedUserController loggedUser;
    
    @Autowired
    public PartidaService(PartidaRepository repo, AuthoritiesRepository authRepo, UserService userService) {
        this.repo = repo;
        this.authRepo = authRepo;
        this.userService = userService;
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

    public void save(Partida partida) {

        partida.setDuracion(0);
        partida.setFaseActual(Fase.INICIANDO);
        partida.setJugadorActivo(1);
        partida.setNumRonda(0);
        partida.setSiguienteJugador(2);
        partida.setTiempoRestRonda(60);
        partida.setUser0(getUserLogged());

        repo.save(partida);
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