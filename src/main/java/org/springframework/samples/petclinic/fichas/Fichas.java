package org.springframework.samples.petclinic.fichas;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Fichas {

	public Integer enanoMazo; //Por defecto 2

	public Integer enanoPico; 

	public Integer posicionEnanoMazo1; // Por defecto posición 0 (Guardado)

	public Integer posicionEnanoMazo2; // Por defecto posición 0 (Guardado)

	public Integer posicionEnanoPico1;

	public Integer posicionEnanoPico2;

}
