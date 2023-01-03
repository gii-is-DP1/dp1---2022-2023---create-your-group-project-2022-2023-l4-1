package org.springframework.samples.petclinic.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.CartaService;
import org.springframework.samples.petclinic.celda.Celda;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.stereotype.Service;

@Service
public class TableroService {

    private TableroRepository tableroRepository;
    private CartaService cartaService;
    private CeldaService celdaService;

    @Autowired
	public TableroService(TableroRepository tableroRepository, CartaService cartaService, CeldaService celdaService) {
		this.tableroRepository = tableroRepository;
        this.cartaService = cartaService;
        this.celdaService = celdaService;
	}

    public Optional<Tablero> findById(Integer id) {
        return tableroRepository.findById(id);
    }

    public List<Tablero> findAll() {
        return tableroRepository.findAll();
    }

    public void save(Partida partida) {
        Tablero tablero = new Tablero();
        tablero.setBackground("resources/images/cueva-juego.png");
        tablero.setHeight(800);
        tablero.setWidth(800);
        tablero.setPartida(partida);

        tableroRepository.save(tablero);

        // Inicializamos las 9 celdas del tablero con las 9 cartas iniciales.
        List<Celda> celdas = new ArrayList<Celda>();
        Celda celda1 = new Celda(); celda1.setCartas(List.of(cartaService.findById(1))); celdas.add(celda1);
        Celda celda2 = new Celda(); celda2.setCartas(List.of(cartaService.findById(2))); celdas.add(celda2);
        Celda celda3 = new Celda(); celda3.setCartas(List.of(cartaService.findById(3))); celdas.add(celda3);
        Celda celda4 = new Celda(); celda4.setCartas(List.of(cartaService.findById(4))); celdas.add(celda4);
        Celda celda5 = new Celda(); celda5.setCartas(List.of(cartaService.findById(5))); celdas.add(celda5);
        Celda celda6 = new Celda(); celda6.setCartas(List.of(cartaService.findById(6))); celdas.add(celda6);
        Celda celda7 = new Celda(); celda7.setCartas(List.of(cartaService.findById(7))); celdas.add(celda7);
        Celda celda8 = new Celda(); celda8.setCartas(List.of(cartaService.findById(8))); celdas.add(celda8);
        Celda celda9 = new Celda(); celda9.setCartas(List.of(cartaService.findById(9))); celdas.add(celda9);

        celdaService.save(celda1, tablero); celdaService.save(celda2, tablero); celdaService.save(celda3, tablero);
        celdaService.save(celda4, tablero); celdaService.save(celda5, tablero); celdaService.save(celda6, tablero);
        celdaService.save(celda7, tablero); celdaService.save(celda8, tablero); celdaService.save(celda9, tablero);
    }
    
}
