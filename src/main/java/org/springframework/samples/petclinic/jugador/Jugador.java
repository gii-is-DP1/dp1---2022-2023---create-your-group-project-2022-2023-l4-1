package org.springframework.samples.petclinic.jugador;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jugador")
public class Jugador extends BaseEntity {

    @NotNull
    private boolean esAdministrador;

    @NotNull
    private boolean esEspectador;

    @NotNull
    private boolean esJugadorInicial;

    @NotNull
    private boolean esGanador;
    
}
