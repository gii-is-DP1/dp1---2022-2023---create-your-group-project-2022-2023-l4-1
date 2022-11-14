package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Partida extends BaseEntity{
    
    @NotNull
    private String nombreSala;

    @NotNull
    @Min(0)
    private Integer duracion;

    @NotNull
    @Min(1)
    private Integer numRonda;



    @NotNull
    @Range(min=0,max=60)
    private Integer tiempoRestRonda;
    
    @NotNull
    @Range(min=0,max=2)
    private Integer jugadorActivo;

    @NotNull
    @Range(min=0,max=2)
    private Integer siguienteJugador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ganador", referencedColumnName = "id")
    private Jugador ganador;
}
