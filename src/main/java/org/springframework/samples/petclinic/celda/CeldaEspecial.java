package org.springframework.samples.petclinic.celda;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.samples.petclinic.carta.CartaEspecial;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.tablero.Tablero;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CeldaEspecial extends BaseEntity{

    @ManyToOne(optional = false)
	private Tablero tablero;

    @ManyToMany
    private List<CartaEspecial> cartas;

    private Boolean ocupado;
    private String ficha;
    
}
