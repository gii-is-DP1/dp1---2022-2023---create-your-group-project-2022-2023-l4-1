package org.springframework.samples.petclinic.CartaDeLaMontana.Acciones;

import org.springframework.samples.petclinic.carta.enums.NombreCartaMontana;
import org.springframework.samples.petclinic.jugador.Jugador;

public interface Accion {
    void actions(Jugador player, String nombreCarta) throws Exception;
	NombreCartaMontana getName();
}
