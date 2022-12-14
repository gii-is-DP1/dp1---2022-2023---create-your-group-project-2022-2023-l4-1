package org.springframework.samples.petclinic.tablero;

import javax.persistence.Entity;
import javax.validation.constraints.Positive;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tablero extends BaseEntity {

    private String background;
    
    @Positive
    private Integer width;

    @Positive
    private Integer height;

    public Tablero() {
        this.background="resources/images/cueva-juego.png";
        this.width=800;
        this.height=800;
    }

    
}
