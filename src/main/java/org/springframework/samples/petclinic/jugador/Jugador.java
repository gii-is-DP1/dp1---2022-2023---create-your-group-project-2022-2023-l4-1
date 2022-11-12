package org.springframework.samples.petclinic.jugador;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jugador")
public class Jugador extends Person {

    @NotNull
    private boolean esAdministrador;

    @NotNull
    private boolean esEspectador;

    @NotNull
    private boolean esJugadorInicial;

    @NotNull
    private boolean esGanador;

    @Column(name = "avatar_url")
	@NotEmpty
	String avatarUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

    
}
