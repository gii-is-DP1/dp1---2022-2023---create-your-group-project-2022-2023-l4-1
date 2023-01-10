package org.springframework.samples.petclinic.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.carta.CartaEspecial;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.Celda;
import org.springframework.samples.petclinic.celda.CeldaEspecial;
import org.springframework.samples.petclinic.celda.CeldaEspecialService;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.celda.enums.Posicion;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.stereotype.Service;

@Service
public class TableroService {

    private TableroRepository tableroRepository;
    private CeldaService celdaService;
    private CartaService cartaService;
    private CeldaEspecialService celdaEspecialService;

    @Autowired
	public TableroService(TableroRepository tableroRepository, CeldaService celdaService, CartaService cartaService,
            CeldaEspecialService celdaEspecialService) {
		this.tableroRepository = tableroRepository;
        this.celdaService = celdaService;
        this.cartaService = cartaService;
        this.celdaEspecialService = celdaEspecialService;
	}

    public Optional<Tablero> findById(Integer id) {
        return tableroRepository.findById(id);
    }

    public List<Tablero> findAll() {
        return tableroRepository.findAll();
    }

    public void save(Partida partida) {
        Tablero tablero = new Tablero();
        tablero.setBackground("/resources/images/cueva-juego.png");
        tablero.setHeight(800);
        tablero.setWidth(800);
        tablero.setPartida(partida);

        tableroRepository.save(tablero);

        // Inicializamos las 9 celdas del tablero con las 9 cartas iniciales.
        Celda celda1 = new Celda(); celda1.setPosicion(Posicion.POS1); celdaService.save(celda1, tablero);
        Celda celda2 = new Celda(); celda2.setPosicion(Posicion.POS2); celdaService.save(celda2, tablero);
        Celda celda3 = new Celda(); celda3.setPosicion(Posicion.POS3); celdaService.save(celda3, tablero);
        Celda celda4 = new Celda(); celda4.setPosicion(Posicion.POS4); celdaService.save(celda4, tablero);
        Celda celda5 = new Celda(); celda5.setPosicion(Posicion.POS5); celdaService.save(celda5, tablero);
        Celda celda6 = new Celda(); celda6.setPosicion(Posicion.POS6); celdaService.save(celda6, tablero);
        Celda celda7 = new Celda(); celda7.setPosicion(Posicion.POS7); celdaService.save(celda7, tablero);
        Celda celda8 = new Celda(); celda8.setPosicion(Posicion.POS8); celdaService.save(celda8, tablero);
        Celda celda9 = new Celda(); celda9.setPosicion(Posicion.POS9); celdaService.save(celda9, tablero);

        // Inicializamos el mazo de la montaña de forma aleatoria.
        List<Carta> montana = new ArrayList<Carta>();

        for (int i = 10; i <= 54; i++) {
            Carta carta = cartaService.findById(i);
            montana.add(carta);
        }

        Collections.shuffle(montana);
        tablero.setMontana(montana);

        // Inicializamos los tres montones de cartas especiales de forma aleatoria.
        List<CartaEspecial> cartasEspeciales = new ArrayList<CartaEspecial>();
        
        for (int i = 1; i <= 9; i++) {
            CartaEspecial cartaEspecial = cartaService.findCartaEspecialById(i);
            cartasEspeciales.add(cartaEspecial);
        }

        Collections.shuffle(cartasEspeciales);

        List<CartaEspecial> cartasEspeciales1 = cartasEspeciales.subList(0, 3);
        List<CartaEspecial> cartasEspeciales2 = cartasEspeciales.subList(3, 6);
        List<CartaEspecial> cartasEspeciales3 = cartasEspeciales.subList(6, 9);

        CeldaEspecial celdaEspecial1 = new CeldaEspecial(); celdaEspecial1.setCartas(cartasEspeciales1); celdaEspecialService.save(celdaEspecial1, tablero);
        CeldaEspecial celdaEspecial2 = new CeldaEspecial(); celdaEspecial2.setCartas(cartasEspeciales2); celdaEspecialService.save(celdaEspecial2, tablero);
        CeldaEspecial celdaEspecial3 = new CeldaEspecial(); celdaEspecial3.setCartas(cartasEspeciales3); celdaEspecialService.save(celdaEspecial3, tablero);

    }

    public void comprobarSiDosCartasSonIguales(Tablero tablero, Partida partida) {
        Carta cartaAColocar1 = tablero.getMontana().get(0);
        Carta cartaAColocar2 = tablero.getMontana().get(1);

        // Si ambas cartas son iguales, el jugador tendrá que colocar una tercera carta, si no son iguales solo se colocan 2.
        if (cartaAColocar1.getPosicion() == cartaAColocar2.getPosicion()) partida.setCartasIguales(true);
    }
    
}
