package org.springframework.samples.petclinic.recurso;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.recurso.enums.TipoRecurso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recursos")
public class Recurso extends BaseEntity {

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TipoRecurso nombre;

    @NotNull
    private Integer cantidadBase;
    
}
