package org.springframework.samples.petclinic.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "username")
	@Id
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	/* 
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "foto_perfil")
	private String fotoPerfil;

	@Size(min = 0, max = 280)
	@Column(name = "biografia")
	private String biografia;

	*/

	@NotNull
	@NotEmpty(message = "No puede estar vacio")
	@Email
	@Column(unique=true)
	private String email;


	private boolean enabled;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities;
}