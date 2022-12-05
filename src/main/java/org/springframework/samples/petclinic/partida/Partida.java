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
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.partida.enums.Fase;
import org.springframework.samples.petclinic.partida.enums.NumRondas;

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

    @Min(1)
    private Integer numRonda;

    @Range(min=0,max=60)
    private Integer tiempoRestRonda;
    
    @Range(min=0,max=2)
    private Integer jugadorActivo;

    @Range(min=0,max=2)
    private Integer siguienteJugador;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "fase_actual")
    private Fase faseActual;

    @OneToOne
    @JoinColumn(name = "ganador", referencedColumnName = "id")
    private Jugador ganador;

    @OneToOne
    @JoinColumn(name = "jugador0", referencedColumnName = "id")
    private Jugador jugador0;
    
    @OneToOne
    @JoinColumn(name = "jugador1", referencedColumnName = "id")
    private Jugador jugador1;
   
    @OneToOne
    @JoinColumn(name = "jugador2", referencedColumnName = "id")
    private Jugador jugador2;

    public List<String> getUsernameList() {
		List<String> pList = new ArrayList<String>();
		
		if(this.jugador0 != null)
			pList.add(this.jugador0.getUser().getUsername());

        if(this.jugador0 != null)
		pList.add(this.jugador1.getUser().getUsername());
		
        if(this.jugador0 != null)
	    pList.add(this.jugador2.getUser().getUsername());
		
		return pList;
	}

    public boolean isNew() {
		return this.nombreSala == null;
	}

    /*@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("nombreSala", this.getNombreSala()()).append("new", this.isNew()).append("rondas", this.getRondas())
				.append("duracion", this.getDuracion()).append("numRonda", this.getNumRonda()).append("tiempoRestRonda", this.getTiempoRestRonda())
				.append("jugadorActivo", this.getJugadorActivo()).append("siguienteJugador", this.getSiguienteJugador())
                .append("faseActual", this.getFaseActual()).append("ganador", this.getGanador())
                .append("jugador0", this.getJugador0()).append("jugador1", this.getJugador1()).append("jugador2", this.getJugador2()).toString();
	}*/
}
