package org.springframework.samples.petclinic.carta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.carta.enums.AccionEspecial;
import org.springframework.samples.petclinic.carta.enums.AccionPosterior;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartas_especiales")
public class CartaEspecial extends CartaBase {

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private AccionEspecial nombre;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "accion_posterior")
    private AccionPosterior accionPosterior;

    @NotNull
    @Column(name = "descripcion_trasera")
    private String descripcionTrasera;
    
}
