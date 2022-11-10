package org.springframework.samples.petclinic.carta;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.samples.petclinic.carta.enums.AccionPosterior;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartas_iniciales")
public class CartaInicial extends Carta {

    @NonNull
    private AccionPosterior nombre;
    
}
