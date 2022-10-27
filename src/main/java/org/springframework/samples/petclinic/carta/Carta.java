package org.springframework.samples.petclinic.carta;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "cartas")
public class Carta {

	@Id
	@Column(name = "Nombre Carta")
	@NotEmpty
	String nombreCarta;

	@Column(name = "Es inicial")
	@NotEmpty
	Boolean esInicial;

	@Column(name = "Posicion")
	@NotEmpty
	Integer posicion; // (1-9)

	@Column(name = "Descripción")
	@NotEmpty
	String descripcion;
	
}
