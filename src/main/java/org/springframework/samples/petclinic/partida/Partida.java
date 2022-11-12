package org.springframework.samples.petclinic.partida;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "partida")
public class Partida extends BaseEntity{
    @NotNull
    @Column(name = "Nombre Sala")
    private String nombreSala;

    @NotNull
    @Column(name = "Duracion")
    @Min(0)
    private Integer duracion;

    @NotNull
    @Column(name = "Numero Ronda")
    @Min(1)
    private Integer numRonda;

    @NotNull
    @Column(name = "Tiempo Restante Ronda")
    @Range(min=0,max=60)
    private Integer tiempoRestRonda;
    
    @NotNull
    @Column(name = "Jugador Activo")
    @Range(min=0,max=2)
    private Integer jugadorActivo;

    @NotNull
    @Range(min=0,max=2)
    @Column(name = "Siguiente Jugador")
    private Integer siguienteJugador;

    @NotNull
    @Column(name = "Ganador")
    @Range(min=0,max=2)
    private Integer ganador; 
}
