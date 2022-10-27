package org.springframework.samples.petclinic.carta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Cartas de la montaña")
public class CartaEspecial extends Carta {

	@Column(name = "AccionEspecial")
	@NotEmpty
	private String accionEspecial;

}
	