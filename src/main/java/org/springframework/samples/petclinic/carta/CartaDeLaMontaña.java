package org.springframework.samples.petclinic.carta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Cartas de la montaña")
public class CartaDeLaMontaña extends Carta {

	@Column(name = "rango")
	@NotEmpty
	private String rango;

	@Column(name = "tipo")
	@NotEmpty
	private String tipo;

}
	