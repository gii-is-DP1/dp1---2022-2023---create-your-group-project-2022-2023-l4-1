package org.springframework.samples.petclinic.tablero;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Positive;

import org.springframework.samples.petclinic.carta.Carta;
import org.springframework.samples.petclinic.carta.CartaEspecial;
import org.springframework.samples.petclinic.celda.Celda;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.partida.Partida;

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

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tablero", fetch = FetchType.EAGER)
    //List<Pieza> piezas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tablero")
    private List<Celda> celdas;

    @OneToOne
    @JoinColumn(name = "partida", referencedColumnName = "id", unique = true)
    private Partida partida;

    @ManyToMany
    private List<Carta> montana;

    @ManyToMany
    private List<CartaEspecial> cartasEspeciales1;

    @ManyToMany
    private List<CartaEspecial> cartasEspeciales2;

    @ManyToMany
    private List<CartaEspecial> cartasEspeciales3;
    
}
