package org.springframework.samples.petclinic.carta;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartas")
public class Carta extends BaseEntity {

    @NotNull
    private String descripcion;

    @NotNull
    @Min(1)
    @Max(12)
    private Integer posicion;
    
}
