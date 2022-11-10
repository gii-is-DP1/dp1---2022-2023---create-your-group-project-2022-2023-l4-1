package org.springframework.samples.petclinic.ficha;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.ficha.enums.Color;
import org.springframework.samples.petclinic.ficha.enums.TipoFicha;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fichas")
public class Ficha extends BaseEntity {
    
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TipoFicha tipo;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Color color;

    @NotNull
    private Integer cantidadBase;

}
