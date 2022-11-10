package org.springframework.samples.petclinic.carta;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.carta.enums.AccionEspecial;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartas_especiales")
public class CartaEspecial extends Carta {

    @NotNull
    private AccionEspecial accionEspecial;

    @NotNull
    private String accionPosterior;
    
}
