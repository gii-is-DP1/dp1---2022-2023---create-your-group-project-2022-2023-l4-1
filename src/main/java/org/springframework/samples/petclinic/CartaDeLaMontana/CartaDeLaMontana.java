package org.springframework.samples.petclinic.CartaDeLaMontana;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.carta.Carta;
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
    @Enumerated(value = EnumType.STRING)
    private NombreCartaMontana nombre;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TipoCarta tipo;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RangoCarta rango;
    
}
