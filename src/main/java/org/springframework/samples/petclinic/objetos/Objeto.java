package org.springframework.samples.petclinic.objetos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.objetos.enums.TipoObjeto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "objetos")
public class Objeto extends BaseEntity{

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TipoObjeto tipoObjeto;
    
    @NotNull
    private Integer cantidadBase;

}
