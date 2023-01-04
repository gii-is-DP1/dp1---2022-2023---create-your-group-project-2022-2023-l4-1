package org.springframework.samples.petclinic.tablero;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.celda.Celda;
import org.springframework.samples.petclinic.celda.CeldaService;
import org.springframework.samples.petclinic.celda.enums.Posicion;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.stereotype.Service;

@Service
public class TableroService {

    private TableroRepository tableroRepository;
    private CeldaService celdaService;

    @Autowired
	public TableroService(TableroRepository tableroRepository, CeldaService celdaService) {
		this.tableroRepository = tableroRepository;
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

    }
    
}
