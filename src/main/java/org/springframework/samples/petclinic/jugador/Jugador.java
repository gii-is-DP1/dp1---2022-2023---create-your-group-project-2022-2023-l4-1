package org.springframework.samples.petclinic.jugador;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jugador")
public class Jugador extends BaseEntity {

    private Boolean esJugadorInicial;
    //private List<Objetos> objetos;
    private Boolean esGanador;
    private Integer numEnanosMazo;
    private Integer numEnanosPico;
    private Integer cantidadHierro;
    private Integer cantidadAcero;
    private Integer cantidadOro;
    private Integer cantidadMedallas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

    @OneToOne
    @JoinColumn(name = "partida", referencedColumnName = "id")
    private Partida partida;

    
}