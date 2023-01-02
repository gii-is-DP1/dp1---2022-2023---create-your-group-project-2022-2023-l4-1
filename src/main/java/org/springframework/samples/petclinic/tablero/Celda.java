package org.springframework.samples.petclinic.tablero;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Celda extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "tablero", referencedColumnName = "id")
	private Tablero tablero;

    @ElementCollection
    private List<Carta> cartas;
    
}
