package org.springframework.samples.petclinic.partida;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chat extends BaseEntity {
    private String mensaje;
    private String username;

    @ManyToOne(optional = false)
	private Partida partida;
}


