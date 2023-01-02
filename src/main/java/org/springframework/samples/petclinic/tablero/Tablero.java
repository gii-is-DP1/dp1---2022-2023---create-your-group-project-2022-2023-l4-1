package org.springframework.samples.petclinic.tablero;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;

import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tablero extends BaseEntity {

    private String background;
    
    @Positive
    private Integer width;

    @Positive
    private Integer height;

    public Tablero() {
        this.background="resources/images/cueva-juego.png";
        this.width=800;
        this.height=800;
    }

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tablero", fetch = FetchType.EAGER)
    //List<Pieza> piezas;

    @OneToMany
    List<Celda> celdas;

    @ElementCollection
    private List<Carta> montana;
    
}
