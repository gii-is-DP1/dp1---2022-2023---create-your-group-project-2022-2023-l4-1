package org.springframework.samples.petclinic.jugador;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.jugador.enums.Objetos;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jugadores")
public class Jugador extends BaseEntity {

    @NotNull
    @Column(name = "es_administrador")
    private boolean esAdministrador;

    @NotNull
    @Column(name = "es_espectador")
    private boolean esEspectador;

    @NotNull
    @Column(name = "es_jugador_inicial")
    private boolean esJugadorInicial;

    /*@NotNull
    private List<Objetos> objetos;*/

    @NotNull
    @Column(name = "es_ganador")
    private boolean esGanador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User usuario;
    
    
}
