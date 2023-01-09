package org.springframework.samples.petclinic.carta;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.carta.enums.NombreCarta;
import org.springframework.samples.petclinic.carta.enums.RangoCarta;
import org.springframework.samples.petclinic.carta.enums.TipoCarta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartas")
public class Carta extends CartaBase {

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private NombreCarta nombre;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TipoCarta tipo;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RangoCarta rango;
    
}
