package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.partida.enums.EspecialActivada;
import org.springframework.samples.petclinic.partida.enums.Fase;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.samples.petclinic.tablero.TableroService;
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
    JugadorService jugadorService;
    TableroService tableroService;
    CeldaService celdaService;
    
    @Autowired
    public PartidaService(PartidaRepository partidaRepository, AuthoritiesRepository authRepo, UserService userService,
            JugadorService jugadorService, TableroService tableroService, CeldaService celdaService) {
        this.partidaRepository = partidaRepository;
        this.authRepo = authRepo;
        this.userService = userService;
        this.jugadorService = jugadorService;
        this.tableroService = tableroService;
        this.celdaService = celdaService;
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

    @Transactional()
    public void deleteUserInAGame(Integer id) {
        Partida game = findPartidaById(id);
        String username = getUserLogged().getUsername();
        List<Jugador> jugadoresInGame = getPlayersInAGame(id);
        if (game.getUser1().getUsername() == username) {
            for (Jugador j: jugadoresInGame) {
                if (j.getUser().getUsername() == getUserLogged().getUsername()) jugadorService.deleteJugadorById(j.getId());
            }
            game.setUser1(game.getUser2());
            game.setUser2(null);
        }
        else {
            for (Jugador j: jugadoresInGame) {
                if (j.getUser().getUsername() == getUserLogged().getUsername()) jugadorService.deleteJugadorById(j.getId());
            }
            game.setUser2(null);
        }
    }

    public void save(Partida partida) {

        partida.setDuracion(0);
        partida.setFaseActual(Fase.INICIANDO);
        partida.setNumRonda(0);
        partida.setTiempoRestRonda(60);
        partida.setCartasColocadas(0);
        partida.setCartasIguales(false);
        partida.setEspecialActivada(EspecialActivada.DESACTIVADA);
        partida.setUser0(getUserLogged());

        partidaRepository.save(partida);
    }

    public void iniciarPartida(Integer id, Tablero tablero) {
        Partida partida = findPartidaById(id);
        partida.setFaseActual(Fase.EXTRACCION);
        tableroService.comprobarSiDosCartasSonIguales(tablero, partida); // Inicializamos la fase de extracción.

        // Obtenemos el jugador que comenzará la partida y el siguiente jugador dependiendo del que haya sido el inicial.
        List<String> usersOnTheGame = partida.getUsersOnTheGame().stream().map(x -> x.getUsername()).collect(Collectors.toList());
        Collections.shuffle(usersOnTheGame);
        partida.setJugadorActivo(usersOnTheGame.get(0));

        if (partida.getUser0().getUsername().equals(partida.getJugadorActivo())) partida.setSiguienteJugador(partida.getUser1().getUsername());
        else if (partida.getUser1().getUsername().equals(partida.getJugadorActivo()) && partida.getUser2() != null) partida.setSiguienteJugador(partida.getUser2().getUsername());
        else if (partida.getUser1().getUsername().equals(partida.getJugadorActivo()) && partida.getUser2() == null) partida.setSiguienteJugador(partida.getUser0().getUsername());
        else if (partida.getUser2().getUsername().equals(partida.getJugadorActivo())) partida.setSiguienteJugador(partida.getUser0().getUsername());
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

    public List<Jugador> getPlayersInAGame(int idPartida) {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        List<Jugador> jugadoresGeneral = jugadorService.getJugadores();
        for (Jugador j: jugadoresGeneral) {
            if (j.getPartida().getId() == idPartida) jugadores.add(j);
        }
        return jugadores;
    }

    public Integer getNumTotalFichas(Partida partida) {
        Integer numTotalFichas = 0;

        Jugador jugador1 = jugadorService.findJugadorInAGame(partida.getUser0().getUsername(), partida);
        numTotalFichas += jugador1.getNumEnanosMazo();
        Jugador jugador2 = jugadorService.findJugadorInAGame(partida.getUser1().getUsername(), partida);
        numTotalFichas += jugador2.getNumEnanosMazo();
        if (partida.getUser2() != null) {
            Jugador jugador3 = jugadorService.findJugadorInAGame(partida.getUser2().getUsername(), partida);
            numTotalFichas += jugador3.getNumEnanosMazo();
        }
        return numTotalFichas;
    }

    public void actualizarTurno(Partida partida) {
        partida.setJugadorActivo(partida.getSiguienteJugador());

        if (partida.getUser0().getUsername().equals(partida.getSiguienteJugador())) partida.setSiguienteJugador(partida.getUser1().getUsername());
        else if (partida.getUser1().getUsername().equals(partida.getSiguienteJugador()) && partida.getUser2() != null) partida.setSiguienteJugador(partida.getUser2().getUsername());
        else if (partida.getUser1().getUsername().equals(partida.getSiguienteJugador()) && partida.getUser2() == null) partida.setSiguienteJugador(partida.getUser0().getUsername());
        else if (partida.getUser2().getUsername().equals(partida.getSiguienteJugador())) partida.setSiguienteJugador(partida.getUser0().getUsername());

        partida.setEspecialActivada(EspecialActivada.DESACTIVADA);
    }

    public void faseExtraccion(Partida partida, Tablero tablero) {
        Carta cartaAColocar = tablero.getMontana().get(0);

        for (Integer i = 1; i <= 9; i++) {
            if (cartaAColocar.getPosicion() == i) {
                tablero.getCeldas().get(i-1).getCartas().add(0, cartaAColocar);
                tablero.getMontana().remove(0);
            }
        }
        partida.setCartasColocadas(partida.getCartasColocadas() + 1);

        // Si ya se han colocado 2 o 3 cartas dependiendo de la casuística que se haya dado, entonces avanzamos de fase y reseteamos los atributos que controlan la colocación de cartas.
        if ((!partida.getCartasIguales() && partida.getCartasColocadas() == 2) || (partida.getCartasIguales() && partida.getCartasColocadas() == 3)) {
            partida.setFaseActual(Fase.SELECCION);
            partida.setCartasColocadas(0);
            partida.setCartasIguales(false);
        }
    }

    public void faseSeleccion(Partida partida, Tablero tablero) {
        if (this.getNumTotalFichas(partida) == 0 || celdaService.comprobarSiTodasCeldasOcupadas(tablero)) partida.setFaseActual(Fase.RESOLUCION);
    }

}