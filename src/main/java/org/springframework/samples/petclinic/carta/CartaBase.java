package org.springframework.samples.petclinic.carta;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class CartaBase extends BaseEntity {

    @NotNull
    private String descripcion;

    @NotNull
    private String imagen;

    @NotNull
    @Range(min=1, max=9)
    private Integer posicion;
    
}
