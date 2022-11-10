package org.springframework.samples.petclinic.carta;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.carta.enums.NombreCartaMontana;
import org.springframework.samples.petclinic.carta.enums.RangoCarta;
import org.springframework.samples.petclinic.carta.enums.TipoCarta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartas_de_la_montana")
public class CartaDeLaMontana extends Carta {

    @NotNull
    private NombreCartaMontana nombreCarta;

    @NotNull
    private TipoCarta tipoCarta;

    @NotNull
    private RangoCarta rango;
    
}
