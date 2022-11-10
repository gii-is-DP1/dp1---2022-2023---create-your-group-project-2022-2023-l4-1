package org.springframework.partida;

import java.time.Duration;

import javax.persistence.Entity;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Partida extends NamedEntity{

    private Duration duracion;
    
    private Integer numRonda;

    private Duration tiempoRestanteRonda;

    private Integer jugadorActivo;

    private Integer siguienteJugador;

    private Integer ganador;

    
}
