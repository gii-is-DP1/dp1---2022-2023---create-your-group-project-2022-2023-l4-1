package org.springframework.samples.petclinic.partida;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "partidas")
public class Partida extends BaseEntity {
    
    @NotNull
    @Column(name = "nombre_sala")
    private String nombreSala;

    @NotNull
    @Min(0)
    private Integer duracion;

    @NotNull
    @Min(1)
    private Integer ronda;
    
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jugador0", referencedColumnName = "id")
    private Jugador jugador0;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jugador1", referencedColumnName = "id")
    private Jugador jugador1;
   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jugador2", referencedColumnName = "id")
    private Jugador jugador2;*/

    @NotNull
    @Range(min=0,max=60)
    @Column(name = "tiempo_restante_ronda")
    private Integer tiempoRestanteRonda;
    
    @NotNull
    @Range(min=0,max=2)
    @Column(name = "jugador_activo")
    private Integer jugadorActivo;

    @NotNull
    @Range(min=0,max=2)
    @Column(name = "siguiente_jugador")
    private Integer siguienteJugador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ganador", referencedColumnName = "id")
    private Jugador ganador;

    /*public List<String> getUsernameList() {
		List<String> pList = new ArrayList<String>();
		
		if(this.jugador0 != null)
			pList.add(this.jugador0.getUsuario().getUsername());

        if(this.jugador0 != null)
		pList.add(this.jugador1.getUsuario().getUsername());
		
        if(this.jugador0 != null)
	    pList.add(this.jugador2.getUsuario().getUsername());
		
		return pList;
	}*/
}
