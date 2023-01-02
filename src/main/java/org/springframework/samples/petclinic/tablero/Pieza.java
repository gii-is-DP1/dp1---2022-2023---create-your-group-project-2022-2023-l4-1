package org.springframework.samples.petclinic.tablero;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.tablero.enums.Color;
import org.springframework.samples.petclinic.tablero.enums.TipoPieza;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "piezas")
public class Pieza extends BaseEntity {
    
    private TipoPieza tipo;
    
    private Color color;

    private Integer cantidadBase;
    
    @Range(min=0,max=3)
    private Integer posicionX;
    
    @Range(min=0,max=2)
    private Integer posicionY;
    
    @ManyToOne
    private Tablero tablero;
    
    
    public Integer getPosicionXEnPixeles(Integer size) {
    	return (posicionX)*size;
    }
    
    public Integer getPosicionYEnPixeles(Integer size) {
    	return (posicionY)*size;
    }

}
