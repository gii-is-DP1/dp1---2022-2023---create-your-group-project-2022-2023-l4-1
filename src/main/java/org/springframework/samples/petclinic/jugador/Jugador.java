package org.springframework.samples.petclinic.jugador;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.objetos.Objeto;
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
    private Boolean esGanador;
    private Integer numEnanosMazo;
    private Integer numEnanosPico;
    private Integer cantidadHierro;
    private Integer cantidadAcero;
    private Integer cantidadOro;
    private Integer cantidadMedallas;
    private Boolean puedeObtenerObjeto;

    @ManyToMany
    private List<Objeto> objetos;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

    @OneToOne
    @JoinColumn(name = "partida", referencedColumnName = "id")
    private Partida partida;
    
}