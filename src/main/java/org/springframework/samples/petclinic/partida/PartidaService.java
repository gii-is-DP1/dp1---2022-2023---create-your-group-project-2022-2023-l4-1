package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.Celda;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.partida.enums.EspecialActivada;
import org.springframework.samples.petclinic.partida.enums.Fase;
import org.springframework.samples.petclinic.partida.enums.NumRondas;
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
    CartaService cartaService;
    
    @Autowired
    public PartidaService(PartidaRepository partidaRepository, AuthoritiesRepository authRepo, UserService userService,
            JugadorService jugadorService, TableroService tableroService, CeldaService celdaService, CartaService cartaService) {
        this.partidaRepository = partidaRepository;
        this.authRepo = authRepo;
        this.userService = userService;
        this.jugadorService = jugadorService;
        this.tableroService = tableroService;
        this.celdaService = celdaService;
        this.cartaService = cartaService;
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

        partida.setFaseActual(Fase.INICIANDO);
        partida.setNumRonda(1);
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

    public Integer getNumTotalFichasMazo(Partida partida) {
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

    public Integer getNumTotalFichasPico(Partida partida) {
        Integer numTotalFichas = 0;

        Jugador jugador1 = jugadorService.findJugadorInAGame(partida.getUser0().getUsername(), partida);
        numTotalFichas += jugador1.getNumEnanosPico();
        Jugador jugador2 = jugadorService.findJugadorInAGame(partida.getUser1().getUsername(), partida);
        numTotalFichas += jugador2.getNumEnanosPico();
        if (partida.getUser2() != null) {
            Jugador jugador3 = jugadorService.findJugadorInAGame(partida.getUser2().getUsername(), partida);
            numTotalFichas += jugador3.getNumEnanosPico();
        }
        return numTotalFichas;
    }

    public Boolean comprobarSiConseguidosTodosObjetos(Partida partida) {
        Boolean hayGanador = false;
        for (User u: partida.getUsersOnTheGame()) {
            Jugador jugador = jugadorService.findJugadorInAGame(u.getUsername(), partida);
            if (jugador.getObjetos().size() == 8) {
                hayGanador = true;
                partida.setGanador(u);
                break;
            }
        }
        return hayGanador;
    }

    public void establecerGanador(Partida partida) {
        Integer puntos1 = 0;
        Integer puntos2 = 0;
        Integer puntos3 = 0;
        Jugador jugador1 = jugadorService.findJugadorInAGame(partida.getUser0().getUsername(), partida);
        Jugador jugador2 = jugadorService.findJugadorInAGame(partida.getUser1().getUsername(), partida);

        if (partida.getUser2() != null) {
            Jugador jugador3 = jugadorService.findJugadorInAGame(partida.getUser2().getUsername(), partida);
            if (jugador1.getCantidadAcero() > jugador2.getCantidadAcero() && jugador1.getCantidadAcero() > jugador3.getCantidadAcero()) puntos1++;
            else if (jugador2.getCantidadAcero() > jugador1.getCantidadAcero() && jugador2.getCantidadAcero() > jugador3.getCantidadAcero()) puntos2++;
            else if (jugador3.getCantidadAcero() > jugador1.getCantidadAcero() && jugador3.getCantidadAcero() > jugador2.getCantidadAcero()) puntos3++;

            if (jugador1.getCantidadOro() > jugador2.getCantidadOro() && jugador1.getCantidadOro() > jugador3.getCantidadOro()) puntos1++;
            else if (jugador2.getCantidadOro() > jugador1.getCantidadOro() && jugador2.getCantidadOro() > jugador3.getCantidadOro()) puntos2++;
            else if (jugador3.getCantidadOro() > jugador1.getCantidadOro() && jugador3.getCantidadOro() > jugador2.getCantidadOro()) puntos3++;

            if (jugador1.getObjetos().size() > jugador2.getObjetos().size() && jugador1.getObjetos().size() > jugador3.getObjetos().size()) puntos1++;
            else if (jugador2.getObjetos().size() > jugador1.getObjetos().size() && jugador2.getObjetos().size() > jugador3.getObjetos().size()) puntos2++;
            else if (jugador3.getObjetos().size() > jugador1.getObjetos().size() && jugador3.getObjetos().size() > jugador2.getObjetos().size()) puntos3++;

            if (jugador1.getCantidadMedallas() > jugador2.getCantidadMedallas() && jugador1.getCantidadMedallas() > jugador3.getCantidadMedallas()) puntos1++;
            else if (jugador2.getCantidadMedallas() > jugador1.getCantidadMedallas() && jugador2.getCantidadMedallas() > jugador3.getCantidadMedallas()) puntos2++;
            else if (jugador3.getCantidadMedallas() > jugador1.getCantidadMedallas() && jugador3.getCantidadMedallas() > jugador2.getCantidadMedallas()) puntos3++;

            if (jugador1.getCantidadHierro() > jugador2.getCantidadHierro() && jugador1.getCantidadHierro() > jugador3.getCantidadHierro()) puntos1++;
            else if (jugador2.getCantidadHierro() > jugador1.getCantidadHierro() && jugador2.getCantidadHierro() > jugador3.getCantidadHierro()) puntos2++;
            else if (jugador3.getCantidadHierro() > jugador1.getCantidadHierro() && jugador3.getCantidadHierro() > jugador2.getCantidadHierro()) puntos3++;

            if (puntos1 > puntos2 && puntos1 > puntos3) {
                partida.setGanador(partida.getUser0());
                jugador1.setEsGanador(true);
            } else if (puntos2 > puntos1 && puntos2 > puntos3) {
                partida.setGanador(partida.getUser1());
                jugador2.setEsGanador(true);
            } else if (puntos3 > puntos1 && puntos3 > puntos2) {
                partida.setGanador(partida.getUser2());
                jugador3.setEsGanador(true);
            }
        } else {
            if (jugador1.getCantidadAcero() > jugador2.getCantidadAcero()) puntos1 += 1;
            else if (jugador1.getCantidadAcero() < jugador2.getCantidadAcero()) puntos2 += 1;

            if (jugador1.getCantidadOro() > jugador2.getCantidadOro()) puntos1 += 1;
            else if (jugador1.getCantidadOro() < jugador2.getCantidadOro()) puntos2 += 1;

            if (jugador1.getObjetos().size() > jugador2.getObjetos().size()) puntos1 += 1;
            else if (jugador1.getObjetos().size() < jugador2.getObjetos().size()) puntos2 += 1;

            if (jugador1.getCantidadMedallas() > jugador2.getCantidadMedallas()) puntos1 += 1;
            else if (jugador1.getCantidadMedallas() < jugador2.getCantidadMedallas()) puntos2 += 1;

            if (jugador1.getCantidadHierro() > jugador2.getCantidadHierro()) puntos1 += 1;
            else if (jugador1.getCantidadHierro() < jugador2.getCantidadHierro()) puntos2 += 1;

            if (puntos1 > puntos2) {
                partida.setGanador(partida.getUser0());
                jugador1.setEsGanador(true);
            } else if (puntos1 < puntos2) {
                partida.setGanador(partida.getUser1());
                jugador2.setEsGanador(true);
            }
        }
        
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
        if (this.getNumTotalFichasMazo(partida) == 0 || celdaService.comprobarSiTodasCeldasOcupadas(tablero)) partida.setFaseActual(Fase.RESOLUCION);
    }

    public void faseResolucionParte1(Partida partida, Tablero tablero) {
        cartaService.ejecutarAyuda(tablero, partida);
    }

    public void faseResolucionParte2(Partida partida, Tablero tablero) {
        cartaService.ejecutarDefensa(tablero, partida);
        cartaService.ejecutarExtraccion(tablero, partida);
        cartaService.ejecutarForja(tablero, partida);

        partida.setNumRonda(partida.getNumRonda() + 1);

        partida.setFaseActual(Fase.EXTRACCION);
        partida.setCartasColocadas(0);
        partida.setCartasIguales(false);
        for (User u: partida.getUsersOnTheGame()) {
            Jugador jugador = jugadorService.findJugadorInAGame(u.getUsername(), partida);
            jugador.setNumEnanosMazo(2);
            jugador.setNumEnanosPico(0);
        }
        for (Integer i = 0; i <= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            celda.setOcupadaPor(null);
            celda.setFicha(null);
            celda.setOcupado(false);
        }
    }

    public void actualizarRonda(Partida partida, Tablero tablero) {
        if (partida.getNumRonda() == 7 && partida.getRondas() == NumRondas.LIMITADAS) {
            partida.setFaseActual(Fase.FINALIZADA);
            this.establecerGanador(partida);
        }
        if (tablero.getMontana().size() == 0) {
            partida.setFaseActual(Fase.FINALIZADA);
            this.establecerGanador(partida);
        }
        if (this.comprobarSiConseguidosTodosObjetos(partida)) {
            partida.setFaseActual(Fase.FINALIZADA);
            this.establecerGanador(partida);
        }
    }

}