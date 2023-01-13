package org.springframework.samples.petclinic.carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.enums.NombreCarta;
import org.springframework.samples.petclinic.carta.enums.TipoCarta;
import org.springframework.samples.petclinic.celda.Celda;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.objetos.Objeto;
import org.springframework.samples.petclinic.objetos.ObjetoService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.enums.EspecialActivada;
import org.springframework.samples.petclinic.tablero.Tablero;
import org.springframework.samples.petclinic.user.User;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    private CartaRepository cartaRepository;
    private CartaEspecialRepository cartaEspecialRepository;
    private ObjetoService objetoService;
    private JugadorService jugadorService;

    @Autowired
    public CartaService(CartaRepository cartaRepository, CartaEspecialRepository cartaEspecialRepository,
            ObjetoService objetoService, JugadorService jugadorService) {
        this.cartaRepository = cartaRepository;
        this.cartaEspecialRepository = cartaEspecialRepository;
        this.objetoService = objetoService;
        this.jugadorService = jugadorService;
    }

    public Carta findById(Integer id) {
        return cartaRepository.findById(id).get();
    }

    public CartaEspecial findCartaEspecialById(Integer id) {
        return cartaEspecialRepository.findById(id).get();
    }

    public void cartaEspecial1(Tablero tablero) {
        for (Integer i = 0; i <= 8; i++) {
            if (tablero.getCeldas().get(i).getCartas().get(0).getTipo() == TipoCarta.Defensa) {
                tablero.getCeldas().get(i).setOcupado(true);
                tablero.getCeldas().get(i).setFicha("/resources/images/fichas/meeple.png");
            }
        }
    }

    public void cartaEspecial2(Tablero tablero) {
        for (Integer i = 0; i <= 8; i++) {
            if (tablero.getCeldas().get(i).getCartas().size() > 1) {
                Carta cartaAColocar = tablero.getCeldas().get(i).getCartas().get(0);
                tablero.getCeldas().get(i).getCartas().remove(0);
                tablero.getMontana().add(cartaAColocar);
            }
        }
    }

    public void cartaEspecial3(Jugador jugador) {
        List<Objeto> objetosDelJugador = jugador.getObjetos();
        Collections.shuffle(objetosDelJugador);
        objetosDelJugador.remove(0);
        jugador.setCantidadOro(jugador.getCantidadOro()+10);
    }

    public void cartaEspecial4(Tablero tablero, Integer posicion) {
        if (tablero.getCeldas().get(posicion).getCartas().size() > 1) {
            Carta cartaAColocar = tablero.getCeldas().get(posicion).getCartas().get(0);
            tablero.getCeldas().get(posicion).getCartas().remove(0);
            if (tablero.getCeldas().get(posicion).getCartas().size() > 2)
                tablero.getCeldas().get(posicion).getCartas().add(1, cartaAColocar);
            else tablero.getCeldas().get(posicion).getCartas().add(cartaAColocar);
        }
    }

    public void cartaEspecial5(Jugador jugador) {
        List<Objeto> objetosAConseguir = objetoService.findAll();
        List<Objeto> objetosDelJugador = jugador.getObjetos();
        List<Objeto> objetosNoConseguidosPorElJugador = new ArrayList<Objeto>();
        for (Objeto o: objetosAConseguir) {
            if (!objetosDelJugador.contains(o)) objetosNoConseguidosPorElJugador.add(o);
        }
        Collections.shuffle(objetosNoConseguidosPorElJugador);
        jugador.getObjetos().add(objetosNoConseguidosPorElJugador.get(0));
    }

    public void cartaEspecial6(Tablero tablero, Partida partida, Integer posicion, String username) {
        Carta cartaAColocar = tablero.getCeldas().get(posicion).getCartas().get(0);
        tablero.getCeldas().get(posicion).getCartas().remove(0);
        tablero.getMontana().add(cartaAColocar);
        tablero.getCeldas().get(posicion).setOcupadaPor(username);
        tablero.getCeldas().get(posicion).setOcupado(true);
        if (partida.getUser0().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple azul.png");
        if (partida.getUser1().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple rojo.png");
        if (partida.getUser2().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple verde.png");
    }

    public void cartaEspecial7(Tablero tablero, Partida partida, Integer posicion, String username) {
        tablero.getCeldas().get(posicion).setOcupadaPor(username);

        if (partida.getUser0().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple azul.png");
        if (partida.getUser1().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple rojo.png");
        if (partida.getUser2().getUsername() == username) tablero.getCeldas().get(posicion).setFicha("/resources/images/fichas/meeple verde.png");
    }

    public void cartaEspecial8(Tablero tablero) {
        for (Integer i = 0; i <= 8; i++) {
            if (tablero.getCeldas().get(i).getCartas().size() > 1) {
                Carta cartaAColocar = tablero.getCeldas().get(i).getCartas().get(0);
                tablero.getCeldas().get(i).getCartas().remove(0);
                tablero.getCeldas().get(i).getCartas().add(cartaAColocar);
            }
        }
    }

    public void cartaEspecial9(Tablero tablero) {
        List<Carta> cartas = new ArrayList<Carta>(); 
        for (Integer i = 0; i <= 8; i++) {
            Carta cartaAColocar = tablero.getCeldas().get(i).getCartas().get(0);
            cartas.add(cartaAColocar);
            tablero.getCeldas().get(i).getCartas().remove(0);
        }
        Collections.shuffle(cartas);
        for (Integer i = 0; i <= 8; i++) {
            for (Integer j = 0; j < cartas.size(); j++) {
                if (i == j) tablero.getCeldas().get(i).getCartas().add(0, cartas.get(j));
            }
        }
    }

    public void ejecutarCartaEspecial(Tablero tablero, Partida partida, Integer posicion, Jugador jugador) {
        if (posicion == 1) this.cartaEspecial1(tablero);
        else if (posicion == 2) this.cartaEspecial2(tablero);
        else if (posicion == 3) this.cartaEspecial3(jugador);
        else if (posicion == 4) partida.setEspecialActivada(EspecialActivada.ESPECIAL4);
        else if (posicion == 5) this.cartaEspecial5(jugador);
        else if (posicion == 6) partida.setEspecialActivada(EspecialActivada.ESPECIAL6);
        else if (posicion == 7) partida.setEspecialActivada(EspecialActivada.ESPECIAL7);
        else if (posicion == 8) this.cartaEspecial8(tablero);
        else if (posicion == 9) this.cartaEspecial9(tablero);
    }

    public void getHelp(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Get_Help && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setNumEnanosPico(2);
                partida.setJugadorActivo(celda.getOcupadaPor());
            }
        }
    }

    public void orcRaiders(Tablero tablero) {
        Boolean ocupada = true;
        for (Integer i = 0; i <= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Orc_Raiders) {
                if (celda.getOcupado() == false) {
                    ocupada = false;
                    break;
                }
            }
        }

        if (!ocupada) {
            for (Integer i = 0; i <= 8; i++) {
                Celda celda = tablero.getCeldas().get(i);
                if (celda.getCartas().get(0).getTipo() == TipoCarta.Extraccion) {
                    celda.setOcupadaPor(null);
                    celda.setOcupado(false);
                    celda.setFicha(null);
                }
            }
        }
    }

    public void knockers(Tablero tablero, Partida partida) {
        Integer celdasDesocupadas = 0;
        for (Integer i = 0; i <= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Knockers) {
                if (celda.getOcupado() == false) {
                    celdasDesocupadas += 1;
                }
            }
        }

        if (celdasDesocupadas > 0) {
            for (User u: partida.getUsersOnTheGame()) {
                Jugador jugador = jugadorService.findJugadorInAGame(u.getUsername(), partida);
                if (jugador.getCantidadHierro() > 0) jugador.setCantidadHierro(jugador.getCantidadHierro() - celdasDesocupadas);
            }
        }
    }

    public void greatDragon(Tablero tablero, Partida partida) {
        Boolean ocupada = true;
        for (Integer i = 0; i <= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Great_Dragon) {
                if (celda.getOcupado() == false) {
                    ocupada = false;
                    break;
                }
            }
        }

        if (!ocupada) {
            for (User u: partida.getUsersOnTheGame()) {
                Jugador jugador = jugadorService.findJugadorInAGame(u.getUsername(), partida);
                jugador.setCantidadOro(0);
            }
        }
    }

    public void dragon(Tablero tablero, Partida partida) {
        Integer celdasDesocupadas = 0;
        for (Integer i = 0; i <= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Dragon) {
                if (celda.getOcupado() == false) {
                    celdasDesocupadas += 1;
                }
            }
        }

        if (celdasDesocupadas > 0) {
            for (User u: partida.getUsersOnTheGame()) {
                Jugador jugador = jugadorService.findJugadorInAGame(u.getUsername(), partida);
                if (jugador.getCantidadOro() > 0) jugador.setCantidadOro(jugador.getCantidadOro() - celdasDesocupadas);
            }
        }
    }

    public void sidhe(Tablero tablero, Partida partida) {
        Integer celdasDesocupadas = 0;
        for (Integer i = 0; i <= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Sidhe) {
                if (celda.getOcupado() == false) {
                    celdasDesocupadas += 1;
                }
            }
        }

        if (celdasDesocupadas > 0) {
            for (User u: partida.getUsersOnTheGame()) {
                Jugador jugador = jugadorService.findJugadorInAGame(u.getUsername(), partida);
                if (jugador.getCantidadOro() > celdasDesocupadas*2 - 1) {
                    jugador.setCantidadOro(jugador.getCantidadOro() - celdasDesocupadas*2);
                    jugador.setCantidadHierro(jugador.getCantidadHierro() + celdasDesocupadas*2);
                } else {
                    jugador.setCantidadHierro(jugador.getCantidadHierro() + jugador.getCantidadOro());
                    jugador.setCantidadOro(0);
                }
            }
        }
    }

    public void obtenerMedallas(Tablero tablero, Partida partida) {
        for (Integer i = 0; i <= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            Carta carta = celda.getCartas().get(0);
            if (carta.getTipo() == TipoCarta.Defensa && celda.getOcupado()) {
                Jugador jugador = jugadorService.findJugadorInAGame(celda.getOcupadaPor(), partida);
                jugador.setCantidadMedallas(jugador.getCantidadMedallas() + 1);
            }
        }
    }

    public void ironSeam(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Iron_Seam && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadHierro(jugador.getCantidadHierro() + 3);
            }
        }
    }

    public void goldSeam(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Gold_Seam && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadOro(jugador.getCantidadOro() + 1);
            }
        }
    }

    public void alloySteel(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Alloy_Steel && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                if (jugador.getCantidadHierro() > 2) {
                    jugador.setCantidadHierro(jugador.getCantidadHierro() - 3);
                    jugador.setCantidadAcero(jugador.getCantidadAcero() + 2);
                } else {
                    jugador.setCantidadHierro(0);
                    jugador.setCantidadAcero(jugador.getCantidadAcero() + 1);
                }
            }
        }
    }

    public void forgeSword(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Sword && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadAcero(jugador.getCantidadAcero() - 3);
                jugador.getObjetos().add(objetoService.findById(1));
            }
        }
    }

    public void forgeMace(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Mace && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadAcero(jugador.getCantidadAcero() - 2);
                jugador.setCantidadOro(jugador.getCantidadOro() - 1);
                jugador.getObjetos().add(objetoService.findById(2));
            }
        }
    }

    public void forgeDiadem(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Diadem && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadHierro(jugador.getCantidadHierro() - 1);
                jugador.setCantidadAcero(jugador.getCantidadAcero() - 1);
                jugador.setCantidadOro(jugador.getCantidadOro() - 1);
                jugador.getObjetos().add(objetoService.findById(3));
            }
        }
    }

    public void forgeHelm(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Helm && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadAcero(jugador.getCantidadAcero() - 1);
                jugador.setCantidadOro(jugador.getCantidadOro() - 2);
                jugador.getObjetos().add(objetoService.findById(4));
            }
        }
    }

    public void forgeAxe(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Axe && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadAcero(jugador.getCantidadAcero() - 2);
                jugador.getObjetos().add(objetoService.findById(5));
            }
        }
    }

    public void forgeCrown(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Crown && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadOro(jugador.getCantidadOro() - 3);
                jugador.getObjetos().add(objetoService.findById(6));
            }
        }
    }

    public void forgeDagger(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Dagger && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadHierro(jugador.getCantidadHierro() - 1);
                jugador.setCantidadAcero(jugador.getCantidadAcero() - 2);
                jugador.getObjetos().add(objetoService.findById(7));
            }
        }
    }

    public void forgeArmour(Tablero tablero, Partida partida) {
        for (Integer i = 0; i<= 8; i++) {
            Celda celda = tablero.getCeldas().get(i);
            if (celda.getCartas().get(0).getNombre() == NombreCarta.Forge_Armour && celda.getOcupado()) {
                String username = celda.getOcupadaPor();
                Jugador jugador = jugadorService.findJugadorInAGame(username, partida);
                jugador.setCantidadAcero(jugador.getCantidadAcero() - 2);
                jugador.setCantidadOro(jugador.getCantidadOro() - 1);
                jugador.getObjetos().add(objetoService.findById(8));
            }
        }
    }

    public void ejecutarAyuda(Tablero tablero, Partida partida) {
        this.getHelp(tablero, partida);
    }

    public void ejecutarDefensa(Tablero tablero, Partida partida) {
        this.obtenerMedallas(tablero, partida);
        this.orcRaiders(tablero);
        this.knockers(tablero, partida);
        this.greatDragon(tablero, partida);
        this.dragon(tablero, partida);
        this.sidhe(tablero, partida);
    }

    public void ejecutarExtraccion(Tablero tablero, Partida partida) {
        this.ironSeam(tablero, partida);
        this.goldSeam(tablero, partida);
        this.alloySteel(tablero, partida);
    }

    public void ejecutarForja(Tablero tablero, Partida partida) {
        this.forgeSword(tablero, partida);
        this.forgeMace(tablero, partida);
        this.forgeDiadem(tablero, partida);
        this.forgeHelm(tablero, partida);
        this.forgeAxe(tablero, partida);
        this.forgeCrown(tablero, partida);
        this.forgeDagger(tablero, partida);
        this.forgeArmour(tablero, partida);
    }
    
}
