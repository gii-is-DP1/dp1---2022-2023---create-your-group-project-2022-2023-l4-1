package org.springframework.samples.petclinic.celda;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.celda.enums.Posicion;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.tablero.Tablero;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Celda extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private Posicion posicion;

    @ManyToOne(optional = false)
	private Tablero tablero;

    @ManyToMany
    private List<Carta> cartas;

    private Boolean ocupado;
    private String ficha;
    
}
