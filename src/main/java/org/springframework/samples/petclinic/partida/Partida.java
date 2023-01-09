package org.springframework.samples.petclinic.partida;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.partida.enums.Fase;
import org.springframework.samples.petclinic.partida.enums.NumRondas;
import org.springframework.samples.petclinic.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Partida extends BaseEntity {
    
    @NotNull
    private String nombreSala;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private NumRondas rondas;

    @Min(0)
    private Integer duracion;

    @Min(0)
    private Integer numRonda;

    @Range(min=0,max=60)
    private Integer tiempoRestRonda;
    
    private String jugadorActivo;

    private String siguienteJugador;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "fase_actual")
    private Fase faseActual;

    @OneToOne
    @JoinColumn(name = "user0", referencedColumnName = "username")
    private User user0;
    
    @OneToOne
    @JoinColumn(name = "user1", referencedColumnName = "username")
    private User user1;
   
    @OneToOne
    @JoinColumn(name = "user2", referencedColumnName = "username")
    private User user2;

    public List<User> getUsersOnTheGame() {

		List<User> usersOnTheGame = new ArrayList<User>();
		
		if(this.user0 != null)
			usersOnTheGame.add(this.user0);

        if(this.user1 != null)
            usersOnTheGame.add(this.user1);
		
        if(this.user2 != null)
            usersOnTheGame.add(this.user2);
		
		return usersOnTheGame;

	}

    @OneToOne
    @JoinColumn(name = "ganador", referencedColumnName = "username")
    private User ganador;

    public boolean isNew() {
		return this.nombreSala == null;
	}

}